package users;

import java.util.TreeMap;

import properties.PropertyIdEnum;
import services.ManagementFactoryIf;

/**
 * UserManagementFactory is a class that extends from ManagementFactoryIf interface
 * and is used as Factory to create user object 

 * @author David
 *
 */
public class UserManagementFactory extends ManagementFactoryIf<UserObjectIf> {
	
	
	/**
	 * It creates a new user object using the name/id and returns it

	 * @param id The user name of the User
	 * @return UserObjectIf newly created user object
	 * */
	public UserObjectIf createObjectById(String id, TreeMap<PropertyIdEnum, String> userProperties) {
		if (id == null || id.isBlank()) {
			System.out.println("The User ID should not be empty");
			return null;
		}
		return new UserObject(id,userProperties);
	}
}
