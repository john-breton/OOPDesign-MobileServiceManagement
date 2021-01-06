/**
 * 
 */
package users;

import properties.NoModifyPropertyModifyBehavior;
import properties.PropertyIf;

/**
 * @author edavleu
 *
 */
public class UserNameProperty extends PropertyIf<String> {
	private static final String PROPERTY_USER_NAME = "User Name";
	
	public UserNameProperty(String name) {
		propertyName = PROPERTY_USER_NAME;
		
		propertyValue = name;
		setPropertyModifyBehavior(new NoModifyPropertyModifyBehavior());
	}

}
