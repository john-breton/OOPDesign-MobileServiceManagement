/**
 * 
 */
package services;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import users.UserObjectIf;

/**
 * @author edavleu
 *
 */
public abstract class UserManagementIf implements PropertyChangeListener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void propertyChange(PropertyChangeEvent arg0);
	
	/**
	 * Adds property change listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public abstract void addPropertyChangeListener(PropertyChangeListener pcl);
	
	/**
	 * Removes property change listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public abstract void removePropertyChangeListener(PropertyChangeListener pcl);
	
	/**
	 * Sets the factory to be used for creating new users.
	 * 
	 * @param userFactory The Factory that is being set.
	 */
	public abstract void setManagementFactory(ManagementFactoryIf<UserObjectIf> userFactory);

	/**
	 * Adds a single user by name and filling the parameters to the user object
	 * @param name The name of the user.
	 * @param address The address o the user.
	 * @param email The email for the user.
	 */
	public abstract void addUser(String name, String address, String email);
	
	/**
	 * Adds a list of users. 
	 * the TreeMap has to use PropertyIdEnum as Key
	 * 
	 * @param users The list of users
	 */
	public abstract void addUsers(ArrayList<TreeMap<PropertyIdEnum, String>> users);
	
	/**
	 * Modify the User Object - identifying them by userId.
	 * the TreeMap has to use PropertyIdEnum as Key
	 * 
	 * @param userName The user name of the user.
	 * @param userProperties The properties that will be used to modify the user.
	 */
	public abstract void modifyUser(String userId, TreeMap<PropertyIdEnum, String> userProperties);
	
	/**
	 * Removes a user by userId 
	 * 
	 * @param userId The user name for the user to be deleted.
	 */
	public abstract void deleteUser(String userId);
	
	/**
	 * Remove a list of users by userId 
	 * 
	 * @param userIds The usernames for the users to be deleted.
	 */
	public abstract void deleteUsers(ArrayList<String> userIds);
	
	/**
	 * Requests a printing of user details by userId
	 * 
	 * @param userId The id of the user that should be printed.
	 */
	public abstract void getUser(String userId);

}
