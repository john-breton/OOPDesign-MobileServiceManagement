package mobileservicemanagementapplication;

import java.util.ArrayList;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import reportingservice.PropertyNameStrings;
import reportingservice.ReportingService;
import services.AbstractUserManagement;
import services.UserManagement;

/**
 * @author edavleu
 *
 */
public class MobileServiceManagementApplicationDemo {

	/**
	 * Entry-point to test The UserManagement service.
	 *
	 * @param args The command line arguments passed during program initialization
	 */
	public static void main(String[] args) {
//		UserManagementService service = new UserManagementService();
		AbstractUserManagement service = UserManagement.getInstance();
		ReportingService reporting = ReportingService.getInstance();
		UserServiceTestRunner runner = new UserServiceTestRunner();
		
		reporting.addPropertyChangeListener(service);
		service.addPropertyChangeListener(reporting);
		runner.addPropertyChangeListener(service);
		runner.addPropertyChangeListener(reporting);
		
		System.out.println("---------------");
		System.out.println("Test Add User");
		System.out.println("---------------");
		
		service.addUser("David", "124 Main St.", "valid.email@gmail.com");
		
		System.out.println("---------------");
		System.out.println("Test Add Users");
		System.out.println("---------------");
		
		ArrayList<TreeMap<PropertyIdEnum, String>> users = new ArrayList<TreeMap<PropertyIdEnum, String>>();
		
		TreeMap<PropertyIdEnum, String> userOne = new TreeMap<PropertyIdEnum, String>();
		userOne.put(PropertyIdEnum.USER_NAME, "John");
		userOne.put(PropertyIdEnum.USER_ADDRESS, "321 Main St.");
		userOne.put(PropertyIdEnum.USER_EMAIL, "john@gmail.com");
		
		TreeMap<PropertyIdEnum, String> userTwo = new TreeMap<PropertyIdEnum, String>();
		userTwo.put(PropertyIdEnum.USER_NAME, "Gabriel");
		userTwo.put(PropertyIdEnum.USER_ADDRESS, "159 Main St.");
		userOne.put(PropertyIdEnum.USER_EMAIL, "gabe@gmail.com");
		
		users.add(userOne);
		users.add(userTwo);
		service.addUsers(users);
		
		System.out.println("---------------");
		System.out.println("Test Modify Users");
		System.out.println("---------------");
		
		TreeMap<PropertyIdEnum, String> vals;
		
		vals = new TreeMap<PropertyIdEnum, String>();
		vals.put(PropertyIdEnum.USER_ADDRESS, "123 Main St.");
		vals.put(PropertyIdEnum.USER_EMAIL, "also.valid.email@gmail.com");
		
		service.modifyUser("David", vals);
		
		System.out.println("---------------");
		
		vals = new TreeMap<PropertyIdEnum, String>();
		vals.put(PropertyIdEnum.USER_NAME, "Gabriel");
		vals.put(PropertyIdEnum.USER_EMAIL, "invalid.email");

		service.modifyUser("John", vals);
		
		System.out.println("---------------");
		System.out.println("Test Get User");
		System.out.println("---------------");
		
		service.getUser("David");
		service.getUser("John");
		service.getUser("Gabriel");
		service.getUser("Steve");
		
		System.out.println("---------------");
		System.out.println("Print all users");
		System.out.println("---------------");
		
		runner.printAllUserNames();
		
		System.out.println("---------------");
		System.out.println("Test Delete User");
		System.out.println("---------------");
		
		service.deleteUser("John", PropertyNameStrings.Events.SUCCESS.getDesc());
		
		System.out.println("---------------");
		System.out.println("Test Delete Users");
		System.out.println("---------------");
		
		ArrayList<String> deleteUsers = new ArrayList<String>();
		deleteUsers.add("Gabriel");
		deleteUsers.add("David");
		service.deleteUsers(deleteUsers);
		
		System.out.println("---------------");
		System.out.println("Print all users");
		System.out.println("---------------");
		
		runner.printAllUserNames();
		
		System.out.println("---------------");
	}

}
