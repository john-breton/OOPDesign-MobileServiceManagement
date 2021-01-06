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
	private static final String PROPERTY_USER_EMAIL = "User Email";
	
	public UserEmailProperty(String email) {
		propertyName = PROPERTY_USER_EMAIL;
		
		propertyValue = email;
		setPropertyModifyBehavior(new EmailPropertyModifyBehavior());
	}

}
