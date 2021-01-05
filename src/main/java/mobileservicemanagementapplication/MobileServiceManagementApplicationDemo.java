/**
 * 
 */
package mobileservicemanagementapplication;

import java.util.TreeMap;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import properties.PropertyIdEnum;
import reportingservice.ConcreteReportingService;
import reportingservice.PropertyNameStrings;
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
		ConcreteReportingService rService = ConcreteReportingService.getInstance();
		MobileServiceManagementClass mService = new MobileServiceManagementClass();
		
		service.addPropertyChangeListener(rService);
		mService.addPropertyChangeListener(service);
		
		System.out.println("Start");
		
		mService.addUser();
		
//		TreeMap<String,Object> newValue = new TreeMap<String,Object>();
//		newValue.put("userId", "Chen");
//		newValue.put("address", "123 Main st.");
//		cmdIssuer.firePropertyChange(PropertyNameStrings.ADD_USER, new TreeMap<String,Object>(), newValue);
		
		System.out.println("End");
//		service.addUser("David");
//		service.addUser("John");
//		
//		service.printAllUsers();
//		
//		TreeMap<PropertyIdEnum, String> vals;
//		
//		vals = new TreeMap<PropertyIdEnum, String>();
//		vals.put(PropertyIdEnum.USER_ADDRESS, "123 Main St.");
//		vals.put(PropertyIdEnum.USER_EMAIL, "valid.email@gmail.com");
//		
//		service.modifyUser("David", vals);
//		
//		service.printAllUsers();
//		
//		vals = new TreeMap<PropertyIdEnum, String>();
//		vals.put(PropertyIdEnum.USER_NAME, "Gabriel");
//		vals.put(PropertyIdEnum.USER_EMAIL, "invalid.email");
//
//		service.modifyUser("John", vals);
//		
//		service.printAllUsers();
	}

}
