/**
 * 
 */
package users;

import java.util.Map;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import properties.PropertyIf;

/**
 * UserObject is a class that extends from the UserObjectIf interface

 * It is the Concrete class for user object
 * @author David
 *
 */
public class UserObject extends UserObjectIf {

	/**
	 * Constructor for creating the user object
	 * @param String name/id
	 * */
	public UserObject(String name) {
		propertyList = new TreeMap<PropertyIdEnum, PropertyIf>();
		propertyList.put(PropertyIdEnum.USER_NAME, new UserNameProperty(name));
		propertyList.put(PropertyIdEnum.USER_ADDRESS, new UserAddressProperty(""));
		propertyList.put(PropertyIdEnum.USER_EMAIL, new UserEmailProperty(""));
	}
	
	/**
	 * used to modify any property of the user object
	 * @param TreeMap<PropertyIdEnum, String> the list of all properties you wish to modify
	 * @return Nothing
	 * */
	public void modifyProperties(TreeMap<PropertyIdEnum, String> vals) {
		for (Map.Entry<PropertyIdEnum, String> entry : vals.entrySet()) {
			PropertyIdEnum propertyId = entry.getKey();
			
			PropertyIf property = propertyList.get(propertyId);
			if (property == null) {
				System.out.println("Could not find property: " + propertyId);
				continue;
			}
			
			property.setValue(entry.getValue());
		}
	}
	
	
	/**
	 * printing all the information about the user
	 * @return String list all properties of current user
	 * */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		for(Map.Entry<PropertyIdEnum, PropertyIf> entry : propertyList.entrySet()) {
			result.append(entry.toString()).append("\n");
		}
		
		return result.toString();
	}

	
	/**
	 * getter for the user id
	 * @return String id of current User
	 * */
	@Override
	public String getId() {
		return getUserName();
	}
	
	/**
	 * getter for the user name
	 * @return String name of current User
	 * */
	public String getUserName() {
		PropertyIf<String> name = propertyList.get(PropertyIdEnum.USER_NAME);
		return name.getValue();
	}

}
