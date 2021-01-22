package usermanagement.mobileservicemanagementapplication;

import java.util.TreeMap;

import reportingservice.ReportingService;
import services.UserManagement;
import usermanagement.properties.PropertyIdEnum;

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
		UserManagement service = UserManagement.getInstance();
		ReportingService reporting = ReportingService.getInstance();
		UserServiceTestRunner runner = new UserServiceTestRunner();
		
		reporting.addPropertyChangeListener(service);
		service.addPropertyChangeListener(reporting);
		runner.addPropertyChangeListener(service);
		runner.addPropertyChangeListener(reporting);
		
		System.out.println("---------------");
		
		service.addUser("David");
		
		System.out.println("---------------");
		
		service.addUser("John");
		
		System.out.println("---------------");
		
		TreeMap<PropertyIdEnum, String> vals;
		
		vals = new TreeMap<PropertyIdEnum, String>();
		vals.put(PropertyIdEnum.USER_ADDRESS, "123 Main St.");
		vals.put(PropertyIdEnum.USER_EMAIL, "valid.email@gmail.com");
		
		service.modifyUser("David", vals);
		
		System.out.println("---------------");
		
		vals = new TreeMap<PropertyIdEnum, String>();
		vals.put(PropertyIdEnum.USER_NAME, "Gabriel");
		vals.put(PropertyIdEnum.USER_EMAIL, "invalid.email");

		service.modifyUser("John", vals);
		
		System.out.println("---------------");
		
		runner.printUser("David");
		
		System.out.println("---------------");
		
		runner.printUser("John");
		
		System.out.println("---------------");
		
		runner.deleteUser("John");
		
		System.out.println("---------------");
		
		runner.printAllUserNames();
		
		System.out.println("---------------");
	}

}
