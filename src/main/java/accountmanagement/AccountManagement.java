package accountmanagement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

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
public class AccountManagement extends AbstractAccountManagement {
    // We will always need an AccountManagement instance, so use eager instantiation.
    private static volatile AccountManagement UNIQUE_INSTANCE = new AccountManagement();
    private volatile ConcurrentHashMap<String, Account> accountList;
    private final PropertyChangeSupport support;
    private final Pattern phoneNumPattern = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");

    /**
     * Constructor for the AccountManagement class.
     * Required to be private to ensure the Singleton Pattern is followed.
     */
    private AccountManagement() {
        support = new PropertyChangeSupport(this);
        accountList = new ConcurrentHashMap<>();
    }

    /**
     * Get the unique AccountManagement instance.
     *
     * @return The Singleton instance of the AccountManagement class.
     */
    public static AccountManagement getInstance() {
        return UNIQUE_INSTANCE;
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
        if (validatePhoneNum(phoneNum)) {
            return;
        }

        // A phone number can only be associated with a single phone number.
        if (accountList.containsKey(phoneNum)) {
            support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), phoneNum);
            return;
        }

        // Add the Account to the list.
        Account acc = new Account(user, phoneNum, bundle);
        accountList.put(phoneNum, acc);
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), phoneNum);
    }

    /**
     * Add an Account object to the list of managed service accounts.
     *
     * @param acc The Account object to be added to the list of managed service accounts.
     */
    public void addAccount(Account acc) {
        // Delegate to the other addAccount method to avoid code repetition.
        addAccount(acc.getUser(), acc.getPhoneNum(), acc.getBundle());
    }

    /**
     * Remove an account from the list of managed accounts.
     *
     * @param phoneNum The phone number for the service account being removed, as a String.
     */
    public void removeAccount(String phoneNum) {
        if (accountList.containsKey(phoneNum)) {
            String deletedUser = accountList.get(phoneNum).getUser();
            support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DELETE, Events.SUCCESS.getDesc(), phoneNum);
            accountList.remove(phoneNum);
            // Special case, the User the account was associated with is not associated with any other Accounts.
            // If that's the case, the User must also be deleted (MR 1.9.10)
            if (accountList.containsValue(deletedUser)) {
                return;
            }
            support.firePropertyChange(USER + PROPERTY_CHANGE_SCOPE_DELIMITER + DELETE, Events.SUCCESS.getDesc(), deletedUser);
            return;
        }
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DELETE, Events.FAILURE.getDesc(), phoneNum);
    }

    /**
     * Update the bundle associated with a service account.
     *
     * @param phoneNum The phone number of the service account that is being updated.
     * @param bundle   The new bundle name identifier that is being associated with the service account.
     */
    public void updateAccountBundle(String phoneNum, String bundle) {
        if (accountList.containsKey(phoneNum)) {
            // Found the service account. Display state prior to update and after update.
            System.out.println("Generating report prior to account update:");
            support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + UPDATING, Events.SUCCESS.getDesc(), phoneNum);
            // Update the bundle and generate a new report.
            accountList.get(phoneNum).setBundle(bundle);
            System.out.println("\nGenerating report after account update:");
            support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + UPDATED, Events.SUCCESS.getDesc(), phoneNum);
            return;
        }
        // No service account exists with the passed phone number.
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + UPDATED, Events.FAILURE.getDesc(), phoneNum);
    }

    /**
     * Get the service account/fees associated with a phone number.
     *
     * @param phoneNum The phone number used to search for the service account.
     * @param mode     True if this is to display an account, false to display the fees associated with the account.
     */
    public void getAccount(String phoneNum, boolean mode) {
        if (accountList.containsKey(phoneNum)) {
            if (mode) {
                support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, phoneNum, ACCOUNT);
            } else {
                support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, accountList.get(phoneNum).getBundle(), Events.FEES.getDesc());
            }
            return;
        }
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, phoneNum, Events.FAILURE.getDesc());
    }

    /**
     * Get the service accounts/fees associated with a username.
     *
     * @param username The username used to search for the service accounts.
     * @param mode     True if this is to display an account, false to display the fees associated with the account.
     */
    public void findAccounts(String username, boolean mode) {
        boolean found = false;
        Set set = accountList.entrySet();
        for (Object o : set) {
            Map.Entry acc = (Map.Entry) o;
            if (((Account) acc.getValue()).getUser().equals(username)) {
                if (mode) {
                    support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, ((Account) acc.getValue()).getPhoneNum(), ACCOUNT);
                } else {
                    support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, ((Account) acc.getValue()).getBundle(), Events.FEES.getDesc());
                }
                found = true;
            }
        }
        if (!found) {
            support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, username, Events.FAILURE.getDesc());
        }
    }

    /**
     * Handle the various event from ReportingService. Any unknown
     * events are ignored.
     *
     * @param evt The event that was received.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case PRINT_ACCOUNT_ADDED:
                if (evt.getOldValue().equals(Events.FAILURE.getDesc())) {
                    System.out.printf("Failed to add a service account for the phone number %s (Used in another service account)%n", evt.getNewValue());
                } else {
                    System.out.printf("Successfully created a service account for the phone number %s%n", evt.getNewValue());
                    printAccountDetails(Objects.requireNonNull(accountList.get(evt.getNewValue())));
                }
                break;
            case PRINT_ACCOUNT_DELETED:
                if (evt.getOldValue().equals(Events.SUCCESS.getDesc())) {
                    System.out.printf("Successfully removed the service account associated with the phone number %s%n", evt.getNewValue());
                    System.out.println("Deleted account details:");
                    printAccountDetails(Objects.requireNonNull(accountList.get(evt.getNewValue())));
                } else {
                    System.out.printf("No service account with the phone number %s was found%n", evt.getNewValue());
                }
                break;
            case PRINT_ACCOUNT_DETAILS:
                if (evt.getOldValue().equals(Events.SUCCESS.getDesc())) {
                    printAccountDetails(Objects.requireNonNull(accountList.get(evt.getNewValue())));
                } else {
                    if (!validatePhoneNum((String) evt.getNewValue())) {
                        System.out.printf("No service account with the phone number %s was found%n", evt.getNewValue());
                    } else {
                        System.out.printf("No service account with the username %s was found%n", evt.getNewValue());
                    }
                }
                break;
            case GET_ACCOUNT:
                getAccount((String) evt.getNewValue(), true);
                break;
            case FIND_ACCOUNTS:
                findAccounts((String) evt.getNewValue(), true);
                break;
            case GET_ACCOUNT_FEES:
                getAccount((String) evt.getNewValue(), false);
                break;
            case FIND_ACCOUNTS_FEES:
                findAccounts((String) evt.getNewValue(), false);
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
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, acc.getUser(), USER);
        // Print the bundle details for the report.
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, acc.getBundle(), BUNDLE);
        System.out.println();
    }

    /**
     * Validates a phone number based on a specific regex pattern.
     *
     * @param phoneNum The phone number to be validated.
     * @return True if the phone number is not in the correct format, false if it is.
     */
    private boolean validatePhoneNum(String phoneNum) {
        if (!phoneNumPattern.matcher(phoneNum).matches()) {
            System.out.println("Incorrect format for phone number.");
            System.out.println("Format should match the following examples:");
            System.out.println("\t+15555555555");
            System.out.println("\t+555555555555");
            System.out.println("\t5555555555");
            System.out.println("\t555-555-5555\n");
            return true;
        }
        return false;
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
