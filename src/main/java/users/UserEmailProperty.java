/**
 * 
 */
package users;

import properties.EmailPropertyModifyBehavior;
import properties.PropertyIf;

/**
 * @author edavleu
 *
 */
public class UserEmailProperty extends PropertyIf<String> {
	
	public UserEmailProperty(String email) {
		propertyName = "User Email";
		
		propertyValue = email;
		setPropertyModifyBehavior(new EmailPropertyModifyBehavior());
	}

}
