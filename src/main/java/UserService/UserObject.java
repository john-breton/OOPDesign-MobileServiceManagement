/**
 * 
 */
package UserService;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author edavleu
 *
 */
public class UserObject extends UserObjectIf {

	public UserObject(String name) {
		propertyList = new TreeMap<PropertyIdEnum, PropertyIf>();
		propertyList.put(PropertyIdEnum.USER_NAME, new UserNameProperty(name));
		propertyList.put(PropertyIdEnum.USER_ADDRESS, new UserAddressProperty(""));
		propertyList.put(PropertyIdEnum.USER_EMAIL, new UserEmailProperty(""));
	}
	
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
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		for(Map.Entry<PropertyIdEnum, PropertyIf> entry : propertyList.entrySet()) {
			result.append(entry.toString()).append("\n");
		}
		
		return result.toString();
	}

	@Override
	public String getId() {
		PropertyIf<String> name = propertyList.get(PropertyIdEnum.USER_NAME);
		return name.propertyValue.toString();
	}

}
