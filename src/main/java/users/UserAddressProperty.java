/**
 * 
 */
package users;

import properties.PropertyIf;
import properties.SimplePropertyModifyBehavior;

/**
 * @author edavleu
 *
 */
public class UserAddressProperty extends PropertyIf<String> {
	
	public UserAddressProperty(String address) {
		propertyName = "User Address";
		
		propertyValue = address;
		setPropertyModifyBehavior(new SimplePropertyModifyBehavior());
	}

}
