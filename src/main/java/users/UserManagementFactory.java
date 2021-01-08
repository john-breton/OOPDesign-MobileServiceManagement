/**
 * 
 */
package users;

import services.ManagementFactoryIf;

/**
 * UserManagementFactory is a class that extends from ManagementFactoryIf interface
 * and used as Factory to create user object 
 * @author David
 *
 */
public class UserManagementFactory extends ManagementFactoryIf<UserObjectIf> {
	
	
	/**
	 * it create a new user object by it name/id and return it
	 * @param String name/id of the User
	 * @return UserObjectIf newly created user object
	 * */
	public UserObjectIf createObjectById(String id) {
		return new UserObject(id);
	}
}
