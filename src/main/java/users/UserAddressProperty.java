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
	private static final String PROPERTY_USER_ADDRESS = "User Address";
	
	public UserAddressProperty(String address) {
		propertyName = PROPERTY_USER_ADDRESS;
		
		propertyValue = address;
		setPropertyModifyBehavior(new SimplePropertyModifyBehavior());
	}

}
