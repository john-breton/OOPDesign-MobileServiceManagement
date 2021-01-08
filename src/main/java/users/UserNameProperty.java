package users;

import properties.NoModifyPropertyModifyBehavior;
import properties.PropertyIf;

/**
 * UserNameProperty is a class that extends from the PropertyIf interface

 * and is used to store the Name property for user object

 * @author David
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
