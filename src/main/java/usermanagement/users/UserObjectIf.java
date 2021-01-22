package usermanagement.users;

import java.util.TreeMap;

import usermanagement.properties.PropertyIdEnum;
import usermanagement.properties.PropertyIf;

/**
 * An abstract class used as an Interface to for User object
 * @author David
 *
 */
public abstract class UserObjectIf {
	protected TreeMap<PropertyIdEnum, PropertyIf> propertyList;
	
	public abstract void modifyProperties(TreeMap<PropertyIdEnum, String> vals);
	public abstract String toString();
	public abstract String getId();
	public abstract String getUserName();
}
