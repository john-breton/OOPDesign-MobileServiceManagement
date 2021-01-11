package accountmanagement;

import reportingservice.ReportingService;

import java.beans.PropertyChangeSupport;

/**
 * Class used to demonstrate the work done on the AccountManagement class.
 * Will be removed when application is ready for submission.
 */
public class AccountDemo {

    public static void main(String[] args) {
        ReportingService reportingService = ReportingService.getInstance();
        AccountManagement accManagement = AccountManagement.getInstance();

        reportingService.addPropertyChangeListener(accManagement);
        accManagement.addPropertyChangeListener(reportingService);

        System.out.println("0----------------\n");
        // Add an Account.
        accManagement.addAccount("john.breton", "905-246-3652", "Gold");
        // Try to add another Account with the same phone number.
        accManagement.addAccount("breton.john", "905-246-3652", "Bronze");
        System.out.println("1----------------\n");

        // Add another account.
        accManagement.addAccount("john.breton", "613-245-6483", "Gold");
        System.out.println("2----------------\n");

        // Add a third account, but pass in the Account object this time.
        Account acc = new Account("david.leung", "555-555-5555", "Silver");
        accManagement.addAccount(acc);
        System.out.println("3----------------");

        // Find an account by phone number.
        accManagement.getAccount("555-555-5555", true);
        System.out.println("4----------------");

        // Display all accounts associated with a username.
        accManagement.findAccounts("john.breton", true);
        System.out.println("5----------------\n");

        // Remove an Account.
        accManagement.removeAccount("905-246-3652");
        System.out.println("6----------------\n");

        // Modify the bundle of an Account.
        accManagement.updateAccountBundle("555-555-5555", "Platinum");
    }
}
