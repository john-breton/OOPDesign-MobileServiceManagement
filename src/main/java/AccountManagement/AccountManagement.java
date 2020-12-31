package AccountManagement;


import java.util.ArrayList;
import java.util.List;

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
public class AccountManagement {
    // We will always need an AccountManagement instance, so use eager instantiation.
    private static final AccountManagement uniqueInstance = new AccountManagement();
    private final List<Account> accountList;

    /**
     *
     */
    private AccountManagement() {
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
     * requires a  User and Bundle object to have already been created and
     * instantiated previously. The phone number is required to be unique,
     * as a specific phone number can only be associated with a single account.
     *
     * @param user     The User that will belong to the account.
     * @param phoneNum The phone number that will be associated with an account.
     *                 Required to be unique, as a specific phone number can
     *                 only be associated with a single account.
     * @param bundle   The Bundle that will belong to the account.
     * @return True if the service account was added, false otherwise.
     */
    public boolean addAccount(User user, String phoneNum, Bundle bundle) {
        // A phoneNum can only be associated with a single Account.
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                System.out.printf(
                        "Failed to add a service account for the phone number %s (Used in another service account)%n",
                        phoneNum);
                return false;
            }
        }

        // Add the Account to the list.
        accountList.add(new Account(user, phoneNum, bundle));
        System.out.printf("Successfully created a service account for the phone number %s%n", phoneNum);
        return true;
    }

    /**
     * Add an Account object to the list of managed service accounts.
     *
     * @param acc The Account object to be added to the list of managed service accounts.
     */
    public void addAccount(Account acc) {
        accountList.add(acc);
        System.out.println("Successfully added the service account to the managed service accounts list.");
    }

    /**
     * Remove an account from the list of managed accounts.
     *
     * @param phoneNum The phone number for the service account being removed, as a String.
     * @return True if the service account was removed successfully, false otherwise.
     */
    public boolean removeAccount(String phoneNum) {
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                User deletedUser = acc.getUser();
                accountList.remove(acc);
                System.out.printf(
                        "Successfully removed the service account associated with the phone number %s%n", phoneNum);
                // Special case, the User the account was associated with is not associated with any other Accounts.
                // If that's the case, the User must also be deleted (MR 1.9.10)
                for (Account accUserCheck : accountList) {
                    if (accUserCheck.getUser().equals(deletedUser)) {
                        return true;
                    }
                }
                // TODO: Notify the UserManagement system to delete the User.
                System.out.println(String.format(
                        "Deleted the user %s as they were not associated with another service account.",
                        deletedUser.getUsername()));
                return true;
            }
        }
        return false;
    }

    /**
     * Update the bundle associated with a service account.
     *
     * @param phoneNum The phone number of the service account that is being updated.
     * @param bundle   The new bundle that is being associated with the service account.
     * @return True if the service account was updated successfully, false otherwise.
     */
    public boolean updateAccountBundle(String phoneNum, Bundle bundle) {
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                // Found the service account.
                System.out.printf(
                        "Successfully updated the bundle of the service account with the phone number %s%n", phoneNum);
                System.out.println(String.format("The new bundle is now %s", bundle));
                acc.setBundle(bundle);
                return true;
            }
        }
        // No service account exists with the passed phone number.
        System.out.printf(
                "Failed to find a service account with the phone number %s (Bundle was not updated)%n", phoneNum);
        return false;
    }

    /**
     * Gets the service account associated with a phone number.
     *
     * @param phoneNum The phone number used to search for the Account.
     * @return The Account associated with the phone number if found, null if no service account is found.
     */
    public Account getAccount(String phoneNum) {
        for (Account acc : accountList) {
            if (acc.getPhoneNum().equals(phoneNum)) {
                System.out.println(acc);
                return acc;
            }
        }
        System.out.println("Failed to find an existing service account with the provided phone number.");
        return null;
    }

}
