/**
 * 
 */
package UserService;

import java.util.TreeMap;

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
