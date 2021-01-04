/**
 * 
 */
package services;

/**
 * @author edavleu
 *
 */
public abstract class ManagementFactoryIf<T> {
	public abstract T createObjectById(String id);
}
