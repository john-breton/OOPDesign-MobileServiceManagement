package userinterface;

import java.util.Scanner;
//put imports for management classes here
import accountmanagement.AccountManagement;
import reportingservice.ConcreteReportingService;
//import accountmanagement.AccountManagement;

/**
 * 
 * @author eleugab
 *
 */
public class UserInterface {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");

        // do initialization stuff
        int option;
        String parameters;
        String[] paramArray;
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\r\n"); // explicitly required to allow the secondary menus to parse a full line

        // UserManagement userService = UserManagement.getInstance();
        // BundleManagement bundleService = BundleManagement.getInstance();
        AccountManagement accountService = AccountManagement.getInstance();
        ConcreteReportingService reportingService = ConcreteReportingService.getInstance();

        do {
            do {
                String menu = "\nPlease enter the number corresponding to the option you want to perform\n"
                        + "0.	Exit Program\n"
                        + "1.	Add User <user details in  comma separated list>\n"
                        + "2.	Add Users <users’ details in  comma separated list>\n" 
                        + "3.	Update User <user>\n"
                        + "4.	Delete User <username>\n" 
                        + "5.	Delete Users< users names list>\n"
                        + "6.	Add Account <phone, user, bundle>\n" 
                        + "7.	Add Account <account>\n"
                        + "8.	Delete Account <phone>\n" 
                        + "9.	Update Account <phone, bundle>\n"
                        + "10.	Add Preconfigured Bundle <bundle name> \n" 
                        + "11.	Add Pac Bundle <bundle name> \n"
                        + "12.	Add Pac Bundle With Calling Option <calling plan name>\n"
                        + "13.	Add Pac Bundle With Messaging Option <messaging plan name>\n"
                        + "14.	List User Details <username>\n" 
                        + "15.	List All Users Names\n"
                        + "16.	List Account <phone number>\n" 
                        + "17.	List Accounts <username>\n"
                        + "18.	List Monthly Fees <phone number>\n"
                        + "19.	List Monthly Fees All Accounts <username>\n"
                        + "20.	List Bundle Details <bundle name>\n" 
                        + "21.	List All Preconfigured Bundles Names\n"
                        + "22.	List All Pac Bundles Names\n";
                System.out.println(menu);
                option = input.nextInt();
            } while(option < 0 || option > 22);

            switch (option) {
            case 0:
                System.out.println("Goodbye!\n");
                break;
            case 1:
                // 1. Add User <user details in comma separated list>
                System.out.println("Please enter a new username, user address, and user email in a comma separated list\n"
                                    + "For example: John Doe, 123 Example St, john.doe@example.com\n");
                parameters = input.next();
                System.out.printf("You inputted: %s\n", parameters);
                // parameters need to be processed into the 3 fields to be passed to UserManagement service.
                break;
            case 2:
                // 2. Add Users <users’ details in comma separated list>
                System.out.println("Please enter a series of new users with details in the following format:\n"
                                    + "First username, First user address, First user email, Second username, Second user address, Second user email, etc\n");
                parameters = input.next();
                System.out.printf("You inputted: %s\n", parameters);
                // parameters need to be processed into the various fields to be passed to UserManagement service.
                break;
            case 3:
                // 3. Update User <user>

                break;
            case 4:
                // 4. Delete User <username>

                break;
            case 5:
                // 5. Delete Users< users names list>

                break;
            case 6:
                // 6. Add Account <phone, user, bundle>
                System.out.println("Please enter the new account phone number, username, and bundle in a comma separated list\n"
                                    + "For example: 555-555-5555, John Doe, Platinum\n");
                parameters = input.next();
                paramArray = parameters.split(", ");
                System.out.printf("You inputted: %s, %s, %s\n", paramArray[0], paramArray[1], paramArray[2]);
                //accountService.addAccount(paramArray[1], paramArray[0], paramArray[2]);
                // AccountManagement should auto-generate a report
                break;
            case 7:
                // 7. Add Account <account>
                // Should account also be a String for the UI? How will this work as adding by an Account object is more backend than frontend?
                break;
            case 8:
                // 8. Delete Account <phone>
                System.out.println("Please enter the phone number for the account you want to delete\n"
                                    + "For example: 555-555-5555\n");
                parameters = input.next();
                System.out.printf("You inputted: %s\n", parameters);
                //accountService.removeAccount(parameters);
                break;
            case 9:
                // 9. Update Account <phone, bundle>
                System.out.println("Please enter the phone number for the account you want to update followed by\n"
                                    + "the desired bundle in a comma separated list\n"
                                    + "For example: 555-555-5555, Platinum\n");
                parameters = input.next();
                paramArray = parameters.split(", ");
                System.out.printf("You inputted: %s, %s\n", paramArray[0], paramArray[1]);
                //accountService.updateAccountBundle(paramArray[0], paramArray[1]);
                break;
            case 10:
                // 10. Add Preconfigured Bundle <bundle name>

                break;
            case 11:
                // 11. Add Pac Bundle <bundle name>

                break;
            case 12:
                // 12. Add Pac Bundle With Calling Option <calling plan name>

                break;
            case 13:
                // 13. Add Pac Bundle With Messaging Option <messaging plan name>

                break;
            case 14:
                // 14. List User Details <username>

                break;
            case 15:
                // 15. List All Users Names

                break;
            case 16:
                // 16. List Account <phone number>
                // Fire a signal here (ACCOUNT::FIND, EVENTS.SUCCESS.getDesc(), phoneNum)

                break;
            case 17:
                // 17. List Accounts <username>
                // Fire a signal here (ACCOUNT::FIND, EVENTS.SPECIAL.getDesc(), username)

                break;
            case 18:
                // 18. List Monthly Fees <phone number>

                break;
            case 19:
                // 19. List Monthly Fees All Accounts <username>

                break;
            case 20:
                // 20. List Bundle Details <bundle name>

                break;
            case 21:
                // 21. List All Preconfigured Bundles Names

                break;
            case 22:
                // 22. List All Pac Bundles Names

                break;
            default:
                System.out.println("Unsupported option, please try again!\n");
                break;
            }
        } while (option != 0);

        // cleanup
        input.close();
    }
}
