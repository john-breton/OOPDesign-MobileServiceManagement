/**
 * 
 */
package users;

import properties.EmailPropertyModifyBehavior;
import properties.PropertyIf;

/**
 * UserEmailProperty is a class that extends from propertyIf interface and holding the email property for user
 * @author David
 *
 */
public class UserEmailProperty extends PropertyIf<String> {
	private static final String PROPERTY_USER_EMAIL = "User Email";
	
	/**
	 * Constructor for creating the user email property
	 * @param String address value
	 * @return Nothing
	 * */
	public UserEmailProperty(String email) {
		propertyName = PROPERTY_USER_EMAIL;
		
		propertyValue = email;
		setPropertyModifyBehavior(new EmailPropertyModifyBehavior());
	}

}
