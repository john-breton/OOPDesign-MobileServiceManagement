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
	
	public UserNameProperty(String name) {
		propertyName = "User Name";
		
		propertyValue = name;
		setPropertyModifyBehavior(new NoModifyPropertyModifyBehavior());
	}

}
