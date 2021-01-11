package userinterface;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import bundlemanagement.service.BundleOption;

import accountmanagement.AccountManagement;
import services.UserManagement;
import bundlemanagement.service.BundleManagement;
import reportingservice.ConcreteReportingService;

/**
 * Class that implements the user interface used to start
 * and interact with the system
 * 
 * @author eleugab
 */
public class UserInterface {
    /**
     * Main method to be run that implements the menu-driven
     * user interface
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");

        // do initialization stuff
        String option;
        String submenuOption;
        String back;
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
                    + "11.	Add Plain Pac Bundle <bundle name> \n"
                    + "12.	Add Pac Bundle With Calling Option <calling plan name>\n"
                    + "13.	Add Pac Bundle With Messaging Option <messaging plan name>\n"
                    + "14.	List User Details <username>\n" 
                    + "15.	List All Users Names\n"
                    + "16.	List Account <phone>\n" 
                    + "17.	List Accounts <username>\n"
                    + "18.	List Monthly Fees <phone>\n"
                    + "19.	List Monthly Fees <username>\n"
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
                    back = addUser(userService, input);
                    if (back.equals("Back")) {
                        break;
                    }
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "2":
                    // 2. Add Users <username, address, email>
                    System.out.println("Please enter a series of new users with details in the following order and format:\n"
                                        + "username, user address, user email\n");
                    ArrayList<TreeMap<PropertyIdEnum, String>> users = new ArrayList<TreeMap<PropertyIdEnum, String>>();
                    do {
                        System.out.println("Enter new user details:\n"
                                            + "Enter 'Back' to go back to the menu\n");
                        submenuOption = input.next();
                        if (!submenuOption.equals("Back")) {
                            System.out.printf("User details to add: %s\n", submenuOption);
                            paramArray = submenuOption.split(", ");
                            TreeMap<PropertyIdEnum, String> user = new TreeMap<PropertyIdEnum, String>();
                            user.put(PropertyIdEnum.USER_NAME,  paramArray[0]);
                            user.put(PropertyIdEnum.USER_ADDRESS,  paramArray[1]);
                            user.put(PropertyIdEnum.USER_EMAIL,  paramArray[2]);
                            users.add(user);
                        }
                    } while (!submenuOption.equals("Back"));
                    if (submenuOption.equals("Back")) {
                        break;
                    }
                    System.out.println("-- Adding Users --");
                    userService.addUsers(users);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "3":
                    // 3. Update User <username, ADDRESS | EMAIL | BOTH, address|email, [address|email]>
                    System.out.println("Please enter the username to update details for followed by one of 'ADDRESS', 'EMAIL' or 'BOTH'\n"
                                        + "then specify the details, all in a comma separated list.\n"
                                        + "Examples:\nJohn Doe, ADDRESS, 123 NewAddress Cres\n"
                                        + "John Doe, EMAIL, new.email@example.com\n"
                                        + "John Doe, BOTH, 123 NewAddress Cres, new.email@example.com\n"
                                        + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
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
                                        + "For example: John Doe\n"
                                        + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    userService.deleteUser(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "5":
                    // 5. Delete Users <username1, username2, username3, etc.>
                    System.out.println("Please enter the usernames of the users to delete in a comma separated list\n"
                            + "For example: John Doe\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    paramArray = parameters.split(", ");
                    ArrayList<String> userList = new ArrayList<String>(Arrays.asList(paramArray));
                    userService.deleteUsers(userList);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "6":
                    // 6. Add Account <phone, user, bundle name>
                    System.out.println("Please enter the new account phone number, username, and bundle name in a comma separated list\n"
                                        + "For example: 555-555-5555, John Doe, Platinum\n"
                                        + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    paramArray = parameters.split(", ");
                    accountService.addAccount(paramArray[1], paramArray[0], paramArray[2]);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "7":
                    // 7. Add Account <account>
                    System.out.println("Step 1. Create a new user or choose an existing user\n");
                    String user = "";
                    do {
                        System.out.println("Select one of the following options by enter the corresponding number:\n"
                                            + "1.  Create a new user\n"
                                            + "2.  Use an existing user\n"
                                            + "3.  Go back to the menu\n");
                        submenuOption = input.next();
                        switch (submenuOption) {
                        case "1":
                            user = addUser(userService, input);
                            break;
                        case "2":
                            System.out.println("These are the existing users:\n");
                            userIfService.listAllUserNames();
                            System.out.println("Please enter an existing username:\n"
                                                + "Enter 'Back' to go back to the menu\n");
                            user = input.next();
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Unrecognized option! Please try again!\n");
                            break;
                        }
                    } while (!submenuOption.matches("[1-3]{1}"));
                    if (submenuOption.equals("3") || user.equals("Back")) {
                        break;
                    }

                    System.out.println("Step 2. Create a new bundle or choose an existing user\n");
                    String bundle = "";
                    do {
                        System.out.println("Select one of the following options by entering the corresponding number:\n"
                                            + "1.  Add Preconfigured Bundle\n" 
                                            + "2.  Add Pac Bundle\n"
                                            + "3.  Add Pac Bundle With Calling Option\n"
                                            + "4.  Add Pac Bundle With Messaging Option\n"
                                            + "5.  Use an existing bundle\n"
                                            + "6.  Go back to the menu\n");
                        submenuOption = input.next();
                        switch (submenuOption) {
                            case "1":
                                bundle = addPreconfBundle(bundleService, input);
                                break;
                            case "2":
                                bundle = addPlainPacBundle(bundleService, input);
                                break;
                            case "3":
                                bundle = addPacBundleWithCalling(bundleService, input);
                                break;
                            case "4":
                                bundle = addPacBundleWithMessaging(bundleService, input);
                                break;
                            case "5":
                                System.out.println("These are the existing bundle options to choose from:\n");
                                userIfService.listAllPreconfBundles();
                                userIfService.listAllPacBundles();
                                System.out.println("Please enter the desired bundle name:\n"
                                                    + "Enter 'Back' to go back to the menu\n");
                                bundle = input.next();
                                break;
                            case "6":
                                break;
                            default:
                                System.out.println("Unrecognized option! Please try again!\n");
                                break;
                        }
                    } while (!submenuOption.matches("[1-6]{1}"));
                    if (submenuOption.equals("6") || bundle.equals("Back")) {
                        break;
                    }

                    System.out.println("\nStep 3. Please enter the phone number for the new account\n"
                                        + "For example: 555-555-5555\n"
                                        + "Enter 'Back' to go back to the menu\n");
                    String phone = input.next();
                    if (phone.equals("Back")) {
                        break;
                    }

                    System.out.println("Creating new account with the details provded\n");
                    accountService.addAccount(user, phone, bundle);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "8":
                    // 8. Delete Account <phone>
                    System.out.println("Please enter the phone number for the account you want to delete\n"
                                        + "For example: 555-555-5555\n"
                                        + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    accountService.removeAccount(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "9":
                    // 9. Update Account <phone, bundle name>
                    System.out.println("Please enter the phone number for the account you want to update followed by\n"
                                        + "the desired bundle in a comma separated list\n"
                                        + "For example: 555-555-5555, Platinum\n"
                                        + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    paramArray = parameters.split(", ");
                    accountService.updateAccountBundle(paramArray[0], paramArray[1]);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "10":
                    // 10.  Add Preconfigured Bundle <bundle name>
                    back = addPreconfBundle(bundleService, input);
                    if (back.equals("Back")) {
                        break;
                    }
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "11":
                    // 11. Add Plain Pac Bundle <bundle name>
                    back = addPlainPacBundle(bundleService, input);
                    if (back.equals("Back")) {
                        break;
                    }
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "12":
                    // 12. Add Pac Bundle With Calling Option <bundle name, calling plan option>
                    back = addPacBundleWithCalling(bundleService, input);
                    if (back.equals("Back")) {
                        break;
                    }
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "13":
                    // 13. Add Pac Bundle With Messaging Option <messaging plan option>
                    back = addPacBundleWithMessaging(bundleService, input);
                    if (back.equals("Back")) {
                        break;
                    }
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "14":
                    // 14. List User Details <username>
                    System.out.println("Please enter the username of the user you want to print the details of\n"
                            + "For example: John Doe\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
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
                    System.out.println("Please enter the phone number of the account you want to print the details of\n"
                            + "For example: 555-555-5555\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    userIfService.listAccount(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "17":
                    // 17. List Accounts <username>
                    // Fire a signal here (ACCOUNT::FIND, EVENTS.SPECIAL.getDesc(), username)
                    System.out.println("Please enter the username of the accounts you want to print the details of\n"
                            + "For example: John Doe\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    userIfService.listAccounts(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "18":
                    // 18. List Monthly Fees <phone>
                    System.out.println("Please enter the phone number of the account you want to print the monthly fees for\n"
                            + "For example: 555-555-5555\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    userIfService.listMonthlyFeesByPhone(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "19":
                    // 19. List Monthly Fees <username>
                    System.out.println("Please enter the username of the accounts you want to print the monthly fees for\n"
                            + "For example: John Doe\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
                    userIfService.listMonthlyFeesByUser(parameters);
                    System.out.println("Hit Enter to return to the menu");
                    input.next();
                    break;
                case "20":
                    // 20. List Bundle Details <bundle name>
                    System.out.println("Please enter the bundle name that you want to view details of\n"
                            + "For example: John's Platinum Bundle\n"
                            + "Enter 'Back' to go back to the menu\n");
                    parameters = input.next();
                    if (parameters.equals("Back")) {
                        break;
                    }
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

    /**
     * Method that implements menu option 1 - Add user. Prints a prompt
     * and waits for user input to pass to the UserManagement instance.
     * If the user enters "Back", immediately returns such that no users
     * are created and the option menu is printed again. Otherwise, 
     * returns the user name of the new user
     * 
     * @param userService UserManagement instance 
     * @param input Scanner instance to get user input
     * @return String of either the user name or "Back"
     */
    private static String addUser(UserManagement userService, Scanner input) {
        System.out.println("Please enter a new username, user address, and user email in a comma separated list\n"
                            + "For example: John Doe, 123 Example St, john.doe@example.com\n"
                            + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        String[] paramArray = parameters.split(", ");
        userService.addUser(paramArray[0], paramArray[1], paramArray[2]);
        return paramArray[0];
    }

    /**
     * Method that implements menu option 10 - Add preconfigured bundle.
     * Prints a prompt and waits for user input to pass to the
     * BundleManagement instance. If the user enters "Back", immediately
     * returns such that no bundle is created and the option menu is
     * printed again. Otherwise, returns the bundle name of the new
     * preconfigured bundle
     * 
     * @param bundleService BundleManagement instance 
     * @param input Scanner instance to get user input
     * @return String of either the bundle name or "Back"
     */
    private static String addPreconfBundle(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter your desired bundle name and one of the following bundle options in a comma separated list\n"
                + "Available Preconfigured Bundle Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                + "For example: John's Platinum Bundle, PLATINUM\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        String[] paramArray = parameters.split(", ");
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
        return paramArray[0];
    }

    /**
     * Method that implements menu option 11 - Add Plain Pac bundle.
     * Prints a prompt and waits for user input to pass to the
     * BundleManagement instance. If the user enters "Back", immediately
     * returns such that no bundle is created and the option menu is
     * printed again. Otherwise, returns the bundle name of the new
     * Plain Pac bundle
     * 
     * @param bundleService BundleManagement instance 
     * @param input Scanner instance to get user input
     * @return String of either the bundle name or "Back"
     */
    private static String addPlainPacBundle(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter your desired plain Pac bundle name\n"
                + "For example: John's Plain Pac Bundle\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        bundleService.addPlainPacBundle(parameters);
        return parameters;
    }

    /**
     * Method that implements menu option 12 - Add Pac bundle
     * with calling plan. Prints a prompt and waits for user
     * input to pass to the BundleManagement instance. If the
     * user enters "Back", immediately returns such that no
     * bundle is created and the option menu is printed again.
     * Otherwise, returns the bundle name of the new Pac bundle
     * with calling plan
     * 
     * @param bundleService BundleManagement instance 
     * @param input Scanner instance to get user input
     * @return String of either the bundle name or "Back"
     */
    private static String addPacBundleWithCalling(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter your desired Pac bundle name and one of the following calling plan options in a comma separated list\n"
                + "Available Calling Plan Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                + "For example: John's Pac Bundle with Platinum Calling, PLATINUM\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        String[] paramArray = parameters.split(", ");
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
        return paramArray[0];
    }

    /**
     * Method that implements menu option 13 - Add Pac bundle
     * with messaging plan. Prints a prompt and waits for user
     * input to pass to the BundleManagement instance. If the
     * user enters "Back", immediately returns such that no
     * bundle is created and the option menu is printed again.
     * Otherwise, returns the bundle name of the new Pac bundle
     * with messaging plan
     * 
     * @param bundleService BundleManagement instance 
     * @param input Scanner instance to get user input
     * @return String of either the bundle name or "Back"
     */
    private static String addPacBundleWithMessaging(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter your desired Pac bundle name and one of the following messaging plan options in a comma separated list\n"
                + "Available Messaging Plan Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                + "For example: John's Pac Bundle with Platinum Messaging, PLATINUM\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        String[] paramArray = parameters.split(", ");
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
                // Fragile with current implementation as inputting anything else will cause system failure because of NullPointerException
                System.out.println("Unrecognized Option! Please enter one of PLATINUM, GOLD, SILVER, BRONZE");
                break;
        }
        bundleService.addPacBundleWithMessaging(paramArray[0], messagingOption);
        return paramArray[0];
    }
}

