package accountmanagement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import static reportingservice.PropertyNameStrings.*;

/**
 * The AccountManagement class is responsible for managing accounts
 * that belong to the overall system. An Account is composed of a User,
 * a Bundle, and a phone number.
 * <p>
 * The AccountManagement class will maintain a list of Accounts in order
 * to perform management operations such as adding, deleting, or modifying
 * an existing account.
 * <p>
 * AccountManagement is a Singleton. This means that the class contains a
 * private constructor and ensures that only one instance of the class will
 * exist at any given time. This is to prevent data corruption once it comes
 * to multiple admins making use of the AccountManagement service.
 */
public class AccountManagement implements PropertyChangeListener {
    // We will always need an AccountManagement instance, so use eager instantiation.
    private static final AccountManagement uniqueInstance = new AccountManagement();
    private final List<Account> accountList;
    private final PropertyChangeSupport support;

    /**
     * Constructor for the AccountManagement class.
     * Required to be private to ensure the Singleton Pattern is followed.
     */
    private AccountManagement() {
        support = new PropertyChangeSupport(this);
        accountList = new ArrayList<>();
    }

    /**
     * Get the unique AccountManagement instance.
     *
     * @return The Singleton instance of the AccountManagement class.
     */
    public static AccountManagement getInstance() {
        return uniqueInstance;
    }

    /**
     * Add a new service account based on the passed in parameters. This
     * requires a User and Bundle object to have already been created and
     * instantiated previously. The phone number is required to be unique,
     * as a specific phone number can only be associated with a single account.
     *
     * @param user     The username identifier that will belong to the account.
     * @param phoneNum The phone number that will be associated with an account.
     *                 Required to be unique, as a specific phone number can
     *                 only be associated with a single account.
     * @param bundle   The bundle name identifier that will belong to the account.
     */
    public void addAccount(String user, String phoneNum, String bundle) {
        // A phoneNum can only be associated with a single Account.
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), acc);
                return;
            }
        }

        // Add the Account to the list.
        Account acc = new Account(user, phoneNum, bundle);
        accountList.add(acc);
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), acc);
    }

    /**
     * Add an Account object to the list of managed service accounts.
     *
     * @param acc The Account object to be added to the list of managed service accounts.
     */
    public void addAccount(Account acc) {
        accountList.add(acc);
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), acc);
    }

    /**
     * Remove an account from the list of managed accounts.
     *
     * @param phoneNum The phone number for the service account being removed, as a String.
     */
    public void removeAccount(String phoneNum) {
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                String deletedUser = acc.getUser();
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DELETE, Events.SUCCESS.getDesc(), acc);
                accountList.remove(acc);
                // Special case, the User the account was associated with is not associated with any other Accounts.
                // If that's the case, the User must also be deleted (MR 1.9.10)
                for (Account accUserCheck : accountList) {
                    if (accUserCheck.getUser().equals(deletedUser)) {
                        return;
                    }
                }
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DELETE, Events.SPECIAL.getDesc(), acc.getUser());
                return;
            }
        }
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DELETE, Events.FAILURE.getDesc(), new Account(null, phoneNum, null));
    }

    /**
     * Update the bundle associated with a service account.
     *
     * @param phoneNum The phone number of the service account that is being updated.
     * @param bundle   The new bundle name identifier that is being associated with the service account.
     */
    public void updateAccountBundle(String phoneNum, String bundle) {
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                // Found the service account. Display state prior to update and after update.
                System.out.println("Generating report prior to account update:");
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + UPDATING, Events.SUCCESS.getDesc(), acc);
                acc.setBundle(bundle);
                System.out.println("\nGenerating report after account update:");
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + UPDATED, Events.SUCCESS.getDesc(), acc);
                return;
            }
        }
        // No service account exists with the passed phone number.
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + UPDATED, Events.FAILURE.getDesc(), new Account(null, phoneNum, null));
    }

    /**
     * Get the service account associated with a phone number.
     *
     * @param phoneNum The phone number used to search for the service account.
     */
    public void getAccount(String phoneNum) {
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, acc, Events.ACCOUNT.getDesc());
                return;
            }
        }
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, new Account(null, phoneNum, null), Events.FAILURE.getDesc());
    }

    /**
     * Get the service accounts associated with a username.
     *
     * @param username The username used to search for the service accounts.
     */
    public void findAccounts(String username) {
        boolean found = false;
        for (Account acc : accountList) {
            if (acc.getUser().equals(username)) {
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, acc, Events.ACCOUNT.getDesc());
                found = true;
            }
        }
        if (!found) {
            support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, new Account(username, null, null), Events.FAILURE.getDesc());
        }
    }

    /**
     * Handle the various event from ConcreteReportingService. Any unknown
     * events are ignored.
     *
     * @param evt The event that was received.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // We are casting an Account object, so if we receive an unknown signal, ignore it.
        if (!evt.getPropertyName().equals(PRINT_ACCOUNT_ADDED) && !evt.getPropertyName().equals(PRINT_ACCOUNT_DELETED) && !evt.getPropertyName().equals(PRINT_ACCOUNT_DETAILS)) {
            return;
        }

        Account acc = (Account) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case PRINT_ACCOUNT_ADDED:
                if (evt.getOldValue().equals(Events.FAILURE.getDesc())) {
                    System.out.printf("Failed to add a service account for the phone number %s (Used in another service account)%n", acc.getPhoneNum());
                } else {
                    System.out.printf("Successfully created a service account for the phone number %s%n", acc.getPhoneNum());
                    printAccountDetails(acc);
                }
                break;
            case PRINT_ACCOUNT_DELETED:
                if (evt.getOldValue().equals(Events.SUCCESS.getDesc())) {
                    System.out.printf("Successfully removed the service account associated with the phone number %s%n", acc.getPhoneNum());
                    System.out.println("Deleted account details:");
                    printAccountDetails(acc);
                } else {
                    System.out.printf("No service account with the phone number %s was found%n", acc.getPhoneNum());
                }
                break;
            case PRINT_ACCOUNT_DETAILS:
                if (evt.getOldValue().equals(Events.SUCCESS.getDesc())) {
                    printAccountDetails(acc);
                } else {
                    if (acc.getPhoneNum() != null) {
                        System.out.printf("No service account with the phone number %s was found%n", acc.getPhoneNum());
                    } else {
                        System.out.printf("No service account with the username %s was found%n", acc.getUser());
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * Generate a report for the given Account.
     * The AccountManagement class delegates most of the report to the
     * UserManagement and BundleManagement classes, as it is unaware of
     * what a User or Bundle is.
     *
     * @param acc The Account to be printed.
     */
    private void printAccountDetails(Account acc) {
        System.out.println("\n-----ACCOUNT REPORT-----");
        System.out.printf("Phone Number: %s%n", acc.getPhoneNum());
        // Print the user details for the report.
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, acc.getUser(), Events.USER.getDesc());
        // Print the bundle details for the report.
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, acc.getBundle(), Events.BUNDLE.getDesc());
        System.out.println("");
    }


    /**
     * Adds listeners to this class.
     *
     * @param pcl a property change listener
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /**
     * Removes listeners to this class.
     *
     * @param pcl a property change listener
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
