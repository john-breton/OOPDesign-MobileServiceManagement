/**
 * 
 */
package users;

import java.util.TreeMap;

import properties.PropertyIdEnum;
import properties.PropertyIf;

/**
 * @author edavleu
 *
 */
public abstract class UserObjectIf {
	protected TreeMap<PropertyIdEnum, PropertyIf> propertyList;
	
	public abstract void modifyProperties(TreeMap<PropertyIdEnum, String> vals);
	public abstract String toString();
	public abstract String getId();
}
