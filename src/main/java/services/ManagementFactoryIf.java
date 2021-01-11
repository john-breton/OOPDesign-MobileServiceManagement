package services;

/**
 * An abstract class used as an Interface for factories

 * @author David
 *
 */
public abstract class ManagementFactoryIf<T> {
	public abstract T createObjectById(String id);
}
