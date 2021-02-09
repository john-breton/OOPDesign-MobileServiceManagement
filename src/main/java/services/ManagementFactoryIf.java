package services;

import java.util.TreeMap;

import properties.PropertyIdEnum;

/**
 * An abstract class used as an Interface for factories

 * @author David
 *
 */
public abstract class ManagementFactoryIf<T> {
	public abstract T createObjectById(String id,TreeMap<PropertyIdEnum, String> userProperties);
}
