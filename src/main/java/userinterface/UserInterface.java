package userinterface;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import accountmanagement.AbstractAccountManagement;
import properties.PropertyIdEnum;

import accountmanagement.AccountManagement;
import services.UserManagement;
import bundlemanagement.service.BundleManagement;
import reportingservice.PropertyNameStrings;
import reportingservice.ReportingService;

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
     * @param args The command-line arguments passed during program execution
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
        ReportingService reportingService = ReportingService.getInstance();

        reportingService.addPropertyChangeListener(userService);
        reportingService.addPropertyChangeListener(bundleService);
        reportingService.addPropertyChangeListener(accountService);
        userService.addPropertyChangeListener(reportingService);
        bundleService.addPropertyChangeListener(reportingService);
        accountService.addPropertyChangeListener(reportingService);
        userIfService.addPropertyChangeListener(reportingService);

        do {
            option = "-1";
            try {
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
                // 1. Add User <username, address, email>
                // 2. Add Users <username, address, email>
                // 3. Update User <username, ADDRESS | EMAIL | BOTH, address|email, [address|email]>
                // 4. Delete User <username>
                // 5. Delete Users <username1, username2, username3, etc.>
                // 6. Add Account <phone, user, bundle name>
                // 7. Add Account <account>
                // 8. Delete Account <phone>
                // 9. Update Account <phone, bundle name>
                // 10.  Add Preconfigured Bundle <bundle name>
                // 11. Add Plain Pac Bundle
                // 12. Add Pac Bundle With Calling Option <bundle name, calling plan option>
                // 13. Add Pac Bundle With Messaging Option <messaging plan option>
                // 14. List User Details <username>
                // 15. List All Users Names
                // 16. List Account <phone>
                // Fire a signal here (ACCOUNT::FIND, EVENTS.SUCCESS.getDesc(), phoneNum)
                // 17. List Accounts <username>
                // Fire a signal here (ACCOUNT::FIND, EVENTS.SPECIAL.getDesc(), username)
                // 18. List Monthly Fees <phone>
                // 19. List Monthly Fees <username>
                // 20. List Bundle Details <bundle name>
                // 21. List All Preconfigured Bundles Names
                // 22. List All Pac Bundles Names
                switch (option) {
                    case "0" -> System.out.println("Goodbye!\n");
                    case "1" -> {
                        back = addUser(userService, input);
                        if (back.equals("Back")) {
                            break;
                        }
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "2" -> {
                        System.out.println("Please enter a series of new users with details in the following order and format:\n"
                                + "username, user address, user email\n");
                        ArrayList<TreeMap<PropertyIdEnum, String>> users = new ArrayList<>();
                        do {
                            System.out.println("Enter new user details:\n"
                                    + "Enter 'Done' to add the inputted user details\n"
                                    + "Enter 'Back' to go back to the menu\n");
                            submenuOption = input.next();
                            if (!(submenuOption.equals("Back") || submenuOption.equals("Done"))) {
                                System.out.printf("User details to add: %s\n", submenuOption);
                                paramArray = submenuOption.split(", ");
                                if (paramArray.length != 3) {
                                    System.out.println("You must enter a username, user address, and user email in a comma separated list");
                                    continue;
                                }
                                TreeMap<PropertyIdEnum, String> user = new TreeMap<>();
                                user.put(PropertyIdEnum.USER_NAME, paramArray[0]);
                                user.put(PropertyIdEnum.USER_ADDRESS, paramArray[1]);
                                user.put(PropertyIdEnum.USER_EMAIL, paramArray[2]);
                                users.add(user);
                            }
                        } while (!(submenuOption.equals("Back") || submenuOption.equals("Done")));
                        if (submenuOption.equals("Back")) {
                            break;
                        }
                        if (users.isEmpty()) {
                            System.out.println("No user details inputted\n"
                                    + "Returning to menu");
                        } else {
                            System.out.println("-- Adding Users --");
                            userService.addUsers(users);
                            System.out.println("Hit Enter to return to the menu");
                            input.next();
                        }
                    }
                    case "3" -> {
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
                        TreeMap<PropertyIdEnum, String> attr = new TreeMap<>();
                        switch (paramArray[1]) {
                            case "ADDRESS" -> {
                                attr.put(PropertyIdEnum.USER_ADDRESS, paramArray[2]);
                                userService.modifyUser(paramArray[0], attr);
                            }
                            case "EMAIL" -> {
                                attr.put(PropertyIdEnum.USER_EMAIL, paramArray[2]);
                                userService.modifyUser(paramArray[0], attr);
                            }
                            case "BOTH" -> {
                                attr.put(PropertyIdEnum.USER_ADDRESS, paramArray[2]);
                                attr.put(PropertyIdEnum.USER_EMAIL, paramArray[3]);
                                userService.modifyUser(paramArray[0], attr);
                            }
                            default -> System.out.println("The specified field to update was unrecognized. "
                                    + "Please try again and enter one of 'ADDRESS', 'EMAIL' or 'BOTH'\n");
                        }
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "4" -> {
                        System.out.println("Please enter the username of the user to delete\n"
                                + "For example: John Doe\n"
                                + "Enter 'Back' to go back to the menu\n");
                        parameters = input.next();
                        if (parameters.equals("Back")) {
                            break;
                        }
                        userService.deleteUser(parameters, PropertyNameStrings.Events.SUCCESS.getDesc());
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "5" -> {
                        System.out.println("Please enter the usernames of the users to delete in a comma separated list\n"
                                + "For example: John Doe, Jane Doe, Joey Doe\n"
                                + "Enter 'Back' to go back to the menu\n");
                        parameters = input.next();
                        if (parameters.equals("Back")) {
                            break;
                        }
                        paramArray = parameters.split(", ");
                        ArrayList<String> userList = new ArrayList<>(Arrays.asList(paramArray));
                        userService.deleteUsers(userList);
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "6" -> {
                        System.out.println("Please enter the new account phone number, username, and bundle name in a comma separated list\n"
                                + "For example: 555-555-5555, John Doe, PLATINUM\n"
                                + "Enter 'Back' to go back to the menu\n");
                        parameters = input.next();
                        if (parameters.equals("Back")) {
                            break;
                        }
                        paramArray = parameters.split(", ");
                        if (!userService.userExists(paramArray[1])) {
                            System.out.println("The inputted user does not exist! Please try again!");
                            break;
                        }
                        if (!bundleService.bundleExists(paramArray[2])) {
                            System.out.println("The inputted bundle does not exist! Please try again!");
                            break;
                        }
                        accountService.addAccount(paramArray[1], paramArray[0], paramArray[2]);
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "7" -> {
                        System.out.println("Step 1. Create a new user or choose an existing user\n");
                        String user = "";
                        boolean invalid = false;
                        do {
                            System.out.println("Select one of the following options by enter the corresponding number:\n"
                                    + "1.  Create a new user\n"
                                    + "2.  Use an existing user\n"
                                    + "3.  Go back to the menu\n");
                            submenuOption = input.next();
                            switch (submenuOption) {
                                case "1" -> {
                                    invalid = false;
                                    user = addUser(userService, input);
                                }
                                case "2" -> {
                                    System.out.println("These are the existing users:\n");
                                    userIfService.listAllUserNames();
                                    System.out.println("Please enter an existing username:\n"
                                            + "Enter 'Back' to go back to the menu\n");
                                    user = input.next();
                                    if (!userService.userExists(user)) {
                                        System.out.println("The inputted user does not exist! Please try again!");
                                        invalid = true;
                                        continue;
                                    }
                                    invalid = false;
                                }
                                case "3" -> invalid = false;
                                default -> System.out.println("Unrecognized option! Please try again!\n");
                            }
                        } while (!submenuOption.matches("[1-3]{1}") || invalid);
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
                                case "1" -> {
                                    invalid = false;
                                    do {
                                        bundle = addPreconfBundle(bundleService, input);
                                    } while (bundle.equals("Error"));
                                }
                                case "2" -> {
                                    System.out.println("Please enter 'PLAINPACBUNDLE' to add a Plain PaC bundle\n"
                                            + "Enter 'Back' to go back to the menu\n");
                                    invalid = false;
                                    do {
                                        parameters = input.next();
                                        if (!(parameters.equals("Back") || parameters.equals("PLAINPACBUNDLE"))) {
                                            System.out.println("Please enter 'PLAINPACBUNDLE' to add a Plain PaC bundle\n"
                                                    + "Enter 'Back' to go back to the menu\n");
                                        }
                                    } while (!(parameters.equals("Back") || parameters.equals("PLAINPACBUNDLE")));
                                    if (parameters.equals("Back")) {
                                        break;
                                    }
                                    bundleService.addPlainPacBundle("PLAINPACBUNDLE");
                                    bundle = "PLAINPACBUNDLE";
                                }
                                case "3" -> {
                                    invalid = false;
                                    do {
                                        bundle = addPacBundleWithCalling(bundleService, input);
                                    } while (bundle.equals("Error"));
                                }
                                case "4" -> {
                                    invalid = false;
                                    do {
                                        bundle = addPacBundleWithMessaging(bundleService, input);
                                    } while (bundle.equals("Error"));
                                    break;
                                case "5":
                                    invalid = false;
                                    System.out.println("These are the existing bundle options to choose from:\n");
                                    userIfService.listAllPreconfBundles();
                                    userIfService.listAllPacBundles();
                                    System.out.println("Please enter the desired bundle name:\n"
                                            + "Enter 'Back' to go back to the menu\n");
                                    bundle = input.next();
                                    if (!bundleService.bundleExists(bundle)) {
                                        System.out.println("The inputted bundle does not exist! Please try again!");
                                        invalid = true;
                                        continue;
                                    }
                                }
                                case "6" -> invalid = false;
                                default -> System.out.println("Unrecognized option! Please try again!\n");
                            }
                        } while (!submenuOption.matches("[1-6]{1}") || invalid);
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
                    }
                    case "8" -> {
                        System.out.println("Please enter the phone number for the account you want to delete\n"
                                + "For example: 555-555-5555\n"
                                + "Enter 'Back' to go back to the menu\n");
                        parameters = input.next();
                        if (parameters.equals("Back")) {
                            break;
                        }
                        if (!accountService.accountExists(parameters)) {
                            System.out.println("No account with the phone number \"" + parameters + "\" exists! Please try again!");
                            break;
                        }
                        accountService.removeAccount(parameters);
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "9" -> {
                        System.out.println("Please enter the phone number for the account you want to update followed by\n"
                                + "the desired bundle in a comma separated list\n"
                                + "For example: 555-555-5555, PLATINUM\n"
                                + "Enter 'Back' to go back to the menu\n");
                        parameters = input.next();
                        if (parameters.equals("Back")) {
                            break;
                        }
                        paramArray = parameters.split(", ");
                        if (!bundleService.bundleExists(paramArray[1])) {
                            System.out.println("The inputted bundle does not exist! Please try again!");
                            break;
                        }
                        accountService.updateAccountBundle(paramArray[0], paramArray[1]);
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "10" -> {
                        do {
                            back = addPreconfBundle(bundleService, input);
                            if (back.equals("Back")) {
                                break;
                            }
                        } while (back.equals("Error"));
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "11" -> {
                        System.out.println("Please enter 'PLAINPACBUNDLE' to add a Plain PaC bundle\n"
                                + "Enter 'Back' to go back to the menu\n");
                        do {
                            parameters = input.next();
                            if (!(parameters.equals("Back") || parameters.equals("PLAINPACBUNDLE"))) {
                                System.out.println("Please enter 'PLAINPACBUNDLE' to add a Plain PaC bundle\n"
                                        + "Enter 'Back' to go back to the menu\n");
                            }
                        } while (!(parameters.equals("Back") || parameters.equals("PLAINPACBUNDLE")));
                        if (parameters.equals("Back")) {
                            break;
                        }
                        bundleService.addPlainPacBundle("PLAINPACBUNDLE");
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "12" -> {
                        do {
                            back = addPacBundleWithCalling(bundleService, input);
                            if (back.equals("Back")) {
                                break;
                            }
                        } while (back.equals("Error"));
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "13" -> {
                        do {
                            back = addPacBundleWithMessaging(bundleService, input);
                            if (back.equals("Back")) {
                                break;
                            }
                        } while (back.equals("Error"));
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "14" -> {
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
                    }
                    case "15" -> {
                        System.out.println("Printing all User Names");
                        userIfService.listAllUserNames();
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "16" -> {
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
                    }
                    case "17" -> {
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
                    }
                    case "18" -> {
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
                    }
                    case "19" -> {
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
                    }
                    case "20" -> {
                        System.out.println("Please enter the bundle name that you want to view details of\n"
                                + "For example: PLATINUM\n"
                                + "Enter 'Back' to go back to the menu\n");
                        parameters = input.next();
                        if (parameters.equals("Back")) {
                            break;
                        }
                        userIfService.printBundleDetails(parameters);
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "21" -> {
                        System.out.println("Printing all Preconfigured Bundle Names");
                        userIfService.listAllPreconfBundles();
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    case "22" -> {
                        System.out.println("Printing all Pac Bundle Names");
                        userIfService.listAllPacBundles();
                        System.out.println("Hit Enter to return to the menu");
                        input.next();
                    }
                    default -> {
                        System.out.println("Unsupported option, please try again!\n"
                                + "Hit Enter to return to the menu");
                        input.next();
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
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
        String[] paramArray;
        do {
            String parameters = input.next();
            if (parameters.equals("Back")) {
                return parameters;
            }
            paramArray = parameters.split(", ");
            if (paramArray.length != 3) {
                System.out.println("You must enter a username, user address, and user email in a comma separated list\n"
                        + "For example: John Doe, 123 Example St, john.doe@example.com\n"
                        + "Enter 'Back' to go back to the menu\n");
            }
        } while (paramArray.length != 3);
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
     * @return String of either the bundle name, "Back", or "Error"
     */
    private static String addPreconfBundle(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter your desired bundle option\n"
                + "Available Preconfigured Bundle Options: PLATINUM, GOLD, SILVER, BRONZE\n"
                + "For example: PLATINUM\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        if (parameters.matches("PLATINUM|GOLD|SILVER|BRONZE")) {
            bundleService.addPreconfBundle(parameters);
            return parameters;
        } else {
            System.out.println("Unrecognized Preconfigured Bundle Option was inputted\n"
                    + "Please try again\n");
            return "Error";
        }
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
     * @return String of either the bundle name, "Back", or "Error"
     */
    private static String addPacBundleWithCalling(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter one of the following PaC with Calling Plan options\n"
                + "Available PaC with Calling Plan Options: PACWITHPLATINUMCALLING, PACWITHGOLDCALLING, "
                + "PACWITHSILVERCALLING, PACWITHBRONZECALLING\n"
                + "For example: PACWITHPLATINUMCALLING\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        if (parameters.matches("PACWITHPLATINUMCALLING|PACWITHGOLDCALLING|PACWITHSILVERCALLING|PACWITHBRONZECALLING")) {
            bundleService.addPacBundleWithCalling(parameters);
            return parameters;
        } else {
            System.out.println("Unrecognized PaC with Calling Plan Option was inputted\n"
                    + "Please try again\n");
            return "Error";
        }
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
     * @return String of either the bundle name, "Back", or "Error"
     */
    private static String addPacBundleWithMessaging(BundleManagement bundleService, Scanner input) {
        System.out.println("Please enter one of the following PaC with Calling Plan options\n"
                + "Available PaC with Calling Plan Options: PACWITHPLATINUMMESSAGING, PACWITHGOLDMESSAGING, "
                + "PACWITHSILVERMESSAGINGVER, PACWITHBRONZEMESSAGING\n"
                + "For example: PACWITHPLATINUMMESSAGING\n"
                + "Enter 'Back' to go back to the menu\n");
        String parameters = input.next();
        if (parameters.equals("Back")) {
            return parameters;
        }
        if (parameters.matches("PACWITHPLATINUMMESSAGING|PACWITHGOLDMESSAGING|PACWITHSILVERMESSAGING|PACWITHBRONZEMESSAGING")) {
            bundleService.addPacBundleWithMessaging(parameters);
            return parameters;
        } else {
            System.out.println("Unrecognized PaC with Messaging Plan Option was inputted\n"
                    + "Please try again\n");
            return "Error";
        }
    }
}

