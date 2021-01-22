package usermanagement.users;

import usermanagement.properties.EmailPropertyModifyBehavior;
import usermanagement.properties.PropertyIf;

/**
 * UserEmailProperty is a class that extends from the propertyIf interface and holds the email property for user

 * @author David
 *
 */
public class UserEmailProperty extends PropertyIf<String> {
	private static final String PROPERTY_USER_EMAIL = "User Email";
	
	/**
	 * Constructor for creating the user email property
	 * @param email The email for the user.
	 * */
	public UserEmailProperty(String email) {
		propertyName = PROPERTY_USER_EMAIL;
		
		propertyValue = email;
		setPropertyModifyBehavior(new EmailPropertyModifyBehavior());
	}

}
