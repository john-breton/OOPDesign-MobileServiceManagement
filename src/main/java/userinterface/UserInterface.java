package userinterface;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import properties.PropertyIdEnum;

//put imports for management classes here
import accountmanagement.AccountManagement;
import services.UserManagement;
import bundlemanagement.service.BundleManagement;
import reportingservice.ConcreteReportingService;

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
        String option;
        String parameters;
        String[] paramArray;
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\r\n"); // explicitly required to allow the secondary menus to parse a full line

        UserManagement userService = UserManagement.getInstance();
        BundleManagement bundleService = BundleManagement.getInstance();
        AccountManagement accountService = AccountManagement.getInstance();
        ConcreteReportingService reportingService = ConcreteReportingService.getInstance();

        reportingService.addPropertyChangeListener(userService);
        reportingService.addPropertyChangeListener(bundleService);
        reportingService.addPropertyChangeListener(accountService);
        userService.addPropertyChangeListener(reportingService);
        bundleService.addPropertyChangeListener(reportingService);
        accountService.addPropertyChangeListener(reportingService);

        do {
            String menu = "\nPlease enter the number corresponding to the option you want to perform\n"
                    + "0.	Exit Program\n"
                    + "1.	Add User <username, address, email>\n"
                    + "2.	Add Users <username, address, email>\n" 
                    + "3.	Update User <username, ADDRESS | EMAIL | BOTH, address|email, [address|email]>\n"
                    + "4.	Delete User <username>\n" 
                    + "5.	Delete Users<username1, username2, username3, etc.>\n"
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
            option = input.next();
            switch (option) {
                case "0":
                    System.out.println("Goodbye!\n");
                    break;
                case "1":
                    // 1. Add User <username, address, email>
                    System.out.println("Please enter a new username, user address, and user email in a comma separated list\n"
                                        + "For example: John Doe, 123 Example St, john.doe@example.com\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    userService.addUser(paramArray[0], paramArray[1], paramArray[2]);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "2":
                    // 2. Add Users <username, address, email>
                    System.out.println("Please enter a series of new users with details in the following order and format:\n"
                                        + "username, user address, user email\n"
                                        + "First new user's details:");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    // I don't think the UI should be creating the ArrayList of user objects to pass to UserManagement::addUsers
                    // Maybe the UI can pass three ArrayLists of each PropertyIdEnum?
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "3":
                    // 3. Update User <username, ADDRESS | EMAIL | BOTH, address|email, [address|email]>
                    System.out.println("Please enter the username to update details for followed by one of 'ADDRESS', 'EMAIL' or 'BOTH'\n"
                                        + "then specify the details, all in a comma separated list.\n"
                                        + "Examples:\nJohn Doe, ADDRESS, 123 NewAddress Cres\n"
                                        + "John Doe, EMAIL, new.email@example.com\n"
                                        + "John Doe, BOTH, 123 NewAddress Cres, new.email@example.com\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    TreeMap<PropertyIdEnum, String> attr = new TreeMap<PropertyIdEnum, String>();
                    switch (paramArray[1]) {
                        case "ADDRESS":
                            attr.put(PropertyIdEnum.USER_ADDRESS,  paramArray[2]);
                            userService.modifyUser(paramArray[0], attr);
                            break;
                        case "EMAIL":
                            attr.put(PropertyIdEnum.USER_EMAIL, paramArray[2]);
                            userService.modifyUser(paramArray[0], attr);
                            break;
                        case "BOTH":
                            attr.put(PropertyIdEnum.USER_ADDRESS,  paramArray[2]);
                            attr.put(PropertyIdEnum.USER_EMAIL, paramArray[3]);
                            userService.modifyUser(paramArray[0], attr);
                            break;
                        default:
                            System.out.println("The specified field to update was unrecognized. "
                                                + "Please try again and enter one of 'ADDRESS', 'EMAIL' or 'BOTH'\n");
                            break;
                    }
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "4":
                    // 4. Delete User <username>
                    System.out.println("Please enter the username of the user to delete\n"
                                        + "For example: John Doe\n");
                    parameters = input.next();
                    userService.deleteUser(parameters);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "5":
                    // 5. Delete Users<username1, username2, username3, etc.>
                    System.out.println("Please enter the usernames of the users to delete in a comma separated list\n"
                            + "For example: John Doe\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    ArrayList<String> userList = new ArrayList<String>(Arrays.asList(paramArray));
                    userService.deleteUsers(userList);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "6":
                    // 6. Add Account <phone, user, bundle>
                    System.out.println("Please enter the new account phone number, username, and bundle in a comma separated list\n"
                                        + "For example: 555-555-5555, John Doe, Platinum\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    accountService.addAccount(paramArray[1], paramArray[0], paramArray[2]);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "7":
                    // 7. Add Account <account>
                    // Should account also be a String for the UI? How will this work as adding by an Account object is more backend than frontend?
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "8":
                    // 8. Delete Account <phone>
                    System.out.println("Please enter the phone number for the account you want to delete\n"
                                        + "For example: 555-555-5555\n");
                    parameters = input.next();
                    accountService.removeAccount(parameters);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "9":
                    // 9. Update Account <phone, bundle>
                    System.out.println("Please enter the phone number for the account you want to update followed by\n"
                                        + "the desired bundle in a comma separated list\n"
                                        + "For example: 555-555-5555, Platinum\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    accountService.updateAccountBundle(paramArray[0], paramArray[1]);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "10":
                    // 10. Add Preconfigured Bundle <bundle name>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "11":
                    // 11. Add Pac Bundle <bundle name>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "12":
                    // 12. Add Pac Bundle With Calling Option <calling plan name>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "13":
                    // 13. Add Pac Bundle With Messaging Option <messaging plan name>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "14":
                    // 14. List User Details <username>
                    System.out.println("Please enter the username of the user you want to print the details of.\n"
                            + "For example: John Doe\n");
                    parameters = input.next();
                    System.out.printf("%s\n", parameters);
                    userService.getUser(parameters);
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "15":
                    // 15. List All Users Names
                    // There is a printAllUserNames() method in the UserServiceTestRunner, but should the event signal being sent
                    // in that class be put into UserManagement?
                    // userService.getUsers();
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "16":
                    // 16. List Account <phone number>
                    // Fire a signal here (ACCOUNT::FIND, EVENTS.SUCCESS.getDesc(), phoneNum)
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "17":
                    // 17. List Accounts <username>
                    // Fire a signal here (ACCOUNT::FIND, EVENTS.SPECIAL.getDesc(), username)
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "18":
                    // 18. List Monthly Fees <phone number>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "19":
                    // 19. List Monthly Fees All Accounts <username>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "20":
                    // 20. List Bundle Details <bundle name>
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "21":
                    // 21. List All Preconfigured Bundles Names
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                case "22":
                    // 22. List All Pac Bundles Names
                    System.out.println("Press any key to return to the menu");
                    input.next();
                    break;
                default:
                    System.out.println("Unsupported option, please try again!\n"
                            + "Press any key to return to the menu");
                    input.next();
                    break;
            }
        } while (!option.equals("0"));

        // cleanup
        input.close();
    }

}
