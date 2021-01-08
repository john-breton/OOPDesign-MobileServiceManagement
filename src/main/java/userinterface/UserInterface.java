package userinterface;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import bundlemanagement.service.BundleOption;

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
        UserInterfaceManagement userIfService = UserInterfaceManagement.getInstance();
        ConcreteReportingService reportingService = ConcreteReportingService.getInstance();

        reportingService.addPropertyChangeListener(userService);
        reportingService.addPropertyChangeListener(bundleService);
        reportingService.addPropertyChangeListener(accountService);
        userService.addPropertyChangeListener(reportingService);
        bundleService.addPropertyChangeListener(reportingService);
        accountService.addPropertyChangeListener(reportingService);
        userIfService.addPropertyChangeListener(reportingService);

        do {
            String menu = "\nPlease enter the number corresponding to the option you want to perform\n"
                    + "0.	Exit Program\n"
                    + "1.	Add User <username, address, email>\n"
                    + "2.	Add Users <username, address, email>\n" 
                    + "3.	Update User <username, ADDRESS | EMAIL | BOTH, address|email, [address|email]>\n"
                    + "4.	Delete User <username>\n" 
                    + "5.	Delete Users <username1, username2, username3, etc.>\n"
                    + "6.	Add Account <phone, user, bundle name>\n" 
                    + "7.	Add Account <account>\n"
                    + "8.	Delete Account <phone>\n" 
                    + "9.	Update Account <phone, bundle name>\n"
                    + "10.	Add Preconfigured Bundle <bundle name> \n" 
                    + "11.	Add Pac Bundle <bundle name> \n"
                    + "12.	Add Pac Bundle With Calling Option <calling plan name>\n"
                    + "13.	Add Pac Bundle With Messaging Option <messaging plan name>\n"
                    + "14.	List User Details <username>\n" 
                    + "15.	List All Users Names\n"
                    + "16.	List Account <phone>\n" 
                    + "17.	List Accounts <username>\n"
                    + "18.	List Monthly Fees <phone>\n"
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
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "2":
                    // 2. Add Users <username, address, email>
                    System.out.println("Option currently unsupported");
                    /* System.out.println("Please enter a series of new users with details in the following order and format:\n"
                                        + "username, user address, user email\n"
                                        + "First new user's details:");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    // I don't think the UI should be creating the ArrayList of user objects to pass to UserManagement::addUsers
                    // Maybe the UI can pass three ArrayLists of each PropertyIdEnum?
                    */
                    System.out.println("Hit Enter to return to the menu");
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
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "4":
                    // 4. Delete User <username>
                    System.out.println("Please enter the username of the user to delete\n"
                                        + "For example: John Doe\n");
                    parameters = input.next();
                    userService.deleteUser(parameters);
                    System.out.println("Hit Enter to return to the menu");
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
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "6":
                    // 6. Add Account <phone, user, bundle name>
                    System.out.println("Please enter the new account phone number, username, and bundle name in a comma separated list\n"
                                        + "For example: 555-555-5555, John Doe, Platinum\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    accountService.addAccount(paramArray[1], paramArray[0], paramArray[2]);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "7":
                    // 7. Add Account <account>
                    // Should account also be a String for the UI? How will this work as adding by an Account object is more backend than frontend?
                    System.out.println("Option currently unsupported");
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "8":
                    // 8. Delete Account <phone>
                    System.out.println("Please enter the phone number for the account you want to delete\n"
                                        + "For example: 555-555-5555\n");
                    parameters = input.next();
                    accountService.removeAccount(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "9":
                    // 9. Update Account <phone, bundle name>
                    System.out.println("Please enter the phone number for the account you want to update followed by\n"
                                        + "the desired bundle in a comma separated list\n"
                                        + "For example: 555-555-5555, Platinum\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    accountService.updateAccountBundle(paramArray[0], paramArray[1]);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "10":
                    // 10. Add Preconfigured Bundle <bundle name, bundle option>
                    System.out.println("Please enter your desired bundle name and one of the following bundle options in a comma separated list\n"
                                        + "Available Preconfigured Bundle Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                                        + "For example: John's Platinum Bundle, PLATINUM\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    BundleOption bundleOption = BundleOption.ZERO;
                    switch (paramArray[1]) {
                        case "PLATINUM":
                            bundleOption = BundleOption.PLATINUM;
                            break;
                        case "GOLD":
                            bundleOption = BundleOption.GOLD;
                            break;
                        case "SILVER":
                            bundleOption = BundleOption.SILVER;
                            break;
                        case "BRONZE":
                            bundleOption = BundleOption.BRONZE;
                            break;
                        default:
                            // Fragile with current implementation as inputting anything else will cause system failure because of NullPointerException
                            System.out.println("Unrecognized Option! Please enter one of PLATINUM, GOLD, SILVER, BRONZE");
                            break;
                    }
                    bundleService.addPreconfBundle(paramArray[0], bundleOption);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "11":
                    // 11. Add Pac Bundle <bundle name>
                    System.out.println("Please enter your desired plain Pac bundle name\n"
                            + "For example: John's Plain Pac Bundle\n");
                    parameters = input.next();
                    bundleService.addPlainPacBundle(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "12":
                    // 12. Add Pac Bundle With Calling Option <bundle name, calling plan option>
                    System.out.println("Please enter your desired Pac bundle name and one of the following calling plan options in a comma separated list\n"
                                        + "Available Calling Plan Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                                        + "For example: John's Pac Bundle with Platinum Calling, PLATINUM\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    BundleOption callingOption = BundleOption.ZERO;
                    switch (paramArray[1]) {
                        case "PLATINUM":
                            callingOption = BundleOption.PLATINUM;
                            break;
                        case "GOLD":
                            callingOption = BundleOption.GOLD;
                            break;
                        case "SILVER":
                            callingOption = BundleOption.SILVER;
                            break;
                        case "BRONZE":
                            callingOption = BundleOption.BRONZE;
                            break;
                        default:
                            // Fragile with current implementation as inputting anything else will cause system failure because of NullPointerException
                            System.out.println("Unrecognized Option! Please enter one of PLATINUM, GOLD, SILVER, BRONZE");
                            break;
                    }
                    bundleService.addPacBundleWithCalling(paramArray[0], callingOption);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "13":
                    // 13. Add Pac Bundle With Messaging Option <messaging plan option>
                    System.out.println("Please enter your desired Pac bundle name and one of the following messaging plan options in a comma separated list\n"
                            + "Available Messaging Plan Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                            + "For example: John's Pac Bundle with Platinum Messaging, PLATINUM\n");
                    parameters = input.next();
                    paramArray = parameters.split(", ");
                    BundleOption messagingOption = BundleOption.ZERO;
                    switch (paramArray[1]) {
                        case "PLATINUM":
                            messagingOption = BundleOption.PLATINUM;
                            break;
                        case "GOLD":
                            messagingOption = BundleOption.GOLD;
                            break;
                        case "SILVER":
                            messagingOption = BundleOption.SILVER;
                            break;
                        case "BRONZE":
                            messagingOption = BundleOption.BRONZE;
                            break;
                        default:
                            // Fragile with current implementation as imputting anything else will cause system failure because of NullPointerException
                            System.out.println("Unrecognized Option! Please enter one of PLATINUM, GOLD, SILVER, BRONZE");
                            break;
                    }
                    bundleService.addPacBundleWithMessaging(paramArray[0], messagingOption);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "14":
                    // 14. List User Details <username>
                    System.out.println("Please enter the username of the user you want to print the details of.\n"
                            + "For example: John Doe\n");
                    parameters = input.next();
                    userService.getUser(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "15":
                    // 15. List All Users Names
                    System.out.println("Printing all User Names");
                    userIfService.listAllUserNames();
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "16":
                    // 16. List Account <phone>
                    // Fire a signal here (ACCOUNT::FIND, EVENTS.SUCCESS.getDesc(), phoneNum)
                    System.out.println("Please enter the phone number of the account you want to print the details of.\n"
                            + "For example: 555-555-5555\n");
                    parameters = input.next();
                    userIfService.listAccount(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "17":
                    // 17. List Accounts <username>
                    // Fire a signal here (ACCOUNT::FIND, EVENTS.SPECIAL.getDesc(), username)
                    System.out.println("Please enter the username of the accounts you want to print the details of.\n"
                            + "For example: John Doe\n");
                    parameters = input.next();
                    userIfService.listAccounts(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "18":
                    // 18. List Monthly Fees <phone>
                    // I don't think there is currently a method that does this by itself
                    System.out.println("Option currently unsupported");
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "19":
                    // 19. List Monthly Fees All Accounts <username>
                    // I don't think there is currently a method that does this by itself
                    System.out.println("Option currently unsupported");
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "20":
                    // 20. List Bundle Details <bundle name>
                    System.out.println("Please enter the bundle name that you want to view details of\n"
                            + "For example: John's Platinum Bundle\n");
                    parameters = input.next();
                    userIfService.printBundleDetails(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "21":
                    // 21. List All Preconfigured Bundles Names
                    System.out.println("Printing all Preconfigured Bundle Names");
                    userIfService.listAllPreconfBundles();
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "22":
                    // 22. List All Pac Bundles Names
                    System.out.println("Printing all Pac Bundle Names");
                    userIfService.listAllPacBundles();
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                default:
                    System.out.println("Unsupported option, please try again!\n"
                            + "Hit Enter to return to the menu");
                    input.next();
                    break;
            }
        } while (!option.equals("0"));

        // cleanup
        input.close();
    }

}
