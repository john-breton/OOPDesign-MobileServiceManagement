/**
 * 
 */
package users;

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

	 * @param String name/id of the User
	 * @return UserObjectIf newly created user object
	 * */
	public UserObjectIf createObjectById(String id) {
		return new UserObject(id);
	}
}
