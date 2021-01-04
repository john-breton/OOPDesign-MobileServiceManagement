/**
 * 
 */
package users;

import services.ManagementFactoryIf;

/**
 * @author edavleu
 *
 */
public class UserManagementFactory extends ManagementFactoryIf<UserObjectIf> {
	
	public UserObjectIf createObjectById(String id) {
		return new UserObject(id);
	}
}
