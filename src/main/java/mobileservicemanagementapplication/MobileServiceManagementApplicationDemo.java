/**
 * 
 */
package mobileservicemanagementapplication;

import java.util.TreeMap;

import properties.PropertyIdEnum;
import services.UserManagement;

/**
 * @author edavleu
 *
 */
public class MobileServiceManagementApplicationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		UserManagementService service = new UserManagementService();
		UserManagement service = UserManagement.getInstance();
		
		service.addUser("David");
		service.addUser("John");
		
		service.printAllUsers();
		
		TreeMap<PropertyIdEnum, String> vals;
		
		vals = new TreeMap<PropertyIdEnum, String>();
		vals.put(PropertyIdEnum.USER_ADDRESS, "123 Main St.");
		vals.put(PropertyIdEnum.USER_EMAIL, "valid.email@gmail.com");
		
		service.modifyUser("David", vals);
		
		service.printAllUsers();
		
		vals = new TreeMap<PropertyIdEnum, String>();
		vals.put(PropertyIdEnum.USER_NAME, "Gabriel");
		vals.put(PropertyIdEnum.USER_EMAIL, "invalid.email");

		service.modifyUser("John", vals);
		
		service.printAllUsers();
	}

}
