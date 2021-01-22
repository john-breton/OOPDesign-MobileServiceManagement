package usermanagement.users;

import usermanagement.properties.PropertyIf;
import usermanagement.properties.SimplePropertyModifyBehavior;

/**
 * UserAddressProperty is a class that extends from propertyIf interface and holding the address property
 * @author David
 *
 */
public class UserAddressProperty extends PropertyIf<String> {
	private static final String PROPERTY_USER_ADDRESS = "User Address";
	
	/**
	 * Constructor for creating the user address property
	 * @param address The user address to be associated with the property
	 * */
	public UserAddressProperty(String address) {
		propertyName = PROPERTY_USER_ADDRESS;
		
		propertyValue = address;
		setPropertyModifyBehavior(new SimplePropertyModifyBehavior());
	}

}
