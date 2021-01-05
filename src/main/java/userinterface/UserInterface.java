package userinterface;

//put imports for management classes here
import reportingservice.ConcreteReportingService;

public class UserInterface {
	public static void main(String[] args) {
		System.out.println("Welcome!");

//		UserManagement userService = UserManagement.getInstance();
//		BundleManagement bundleService = BundleManagement.getInstance();
//		AccountManagement accountService = AccountManagement.getInstance();
		ConcreteReportingService reportingService = ConcreteReportingService.getInstance();

		while (true) {
			System.out.println("1.	Add User <user details in  comma separated list>\r\n"
					+ "2.	Add Users <users’ details in  comma separated list>\r\n" 
					+ "3.	Update User <user>\r\n"
					+ "4.	Delete User <username>\r\n" 
					+ "5.	Delete Users< users names list>\r\n"
					+ "6.	Add Account <phone, user, bundle>\r\n" 
					+ "7.	Add Account <account>\r\n"
					+ "8.	Delete Account <phone>\r\n" 
					+ "9.	Update Account <phone, bundle>\r\n"
					+ "10.	Add Preconfigured Bundle <bundle name> \r\n" 
					+ "11.	Add Pac Bundle <bundle name> \r\n"
					+ "12.	Add Pac Bundle With Calling Option <calling plan name>\r\n"
					+ "13.	Add Pac Bundle With Messaging Option <messaging plan name>\r\n"
					+ "14.	List User Details <username>\r\n" 
					+ "15.	List All Users Names\r\n"
					+ "16.	List Account <phone number>\r\n" 
					+ "17.	List Accounts <username>\r\n"
					+ "18.	List Monthly Fees <phone number>\r\n"
					+ "19.	List Monthly Fees All Accounts <username>\r\n"
					+ "20.	List Bundle Details <bundle name>\r\n" 
					+ "21.	List All Preconfigured Bundles Names\r\n"
					+ "22.	List All Pac Bundles Names\r\n");

			// wait for user to input a number, assign it to userInput
			int userInput = 0;

			switch (userInput) {
			case 1:
				// 1. Add User <user details in comma separated list>
				System.out.println("please enter your user details in a comma separated list");
				break;
			case 2:
				// 2. Add Users <users’ details in comma separated list>

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

				break;
			case 7:
				// 7. Add Account <account>

				break;
			case 8:
				// 8. Delete Account <phone>

				break;
			case 9:
				// 9. Update Account <phone, bundle>

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

				break;
			case 17:
				// 17. List Accounts <username>

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
				break;
			}
		}
	}
}
