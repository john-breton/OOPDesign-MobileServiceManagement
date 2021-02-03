package services;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import users.UserObjectIf;
/**
 * This is an abstract class for the UserManagement class
 * @author esiumat
 *
 */
public abstract class AbstractUserManagement implements PropertyChangeListener {
	
	/**
	 * Add a single user by name, it will set the attributes empty string by default
	 * @param name (Surfoplane) The user name of the user to be added
	 */
	public abstract void addUser(String name);
	
	/**
	 * Overloaded Method
	 * Add a single user by name and filling the parameters to the user object
	 * @param name (Surfoplance) The username for the user.
	 * @param address The address for the user.
	 * @param email address The email for the user.
	 */
	public abstract void addUser(String name, String address, String email);
	
	/**
	 * Add a list of users in to the system. 
	 * the TreeMap has to use PropertyIdEnum as Key
	 * 
	 * @param users The list of users
	 */
	public abstract void addUsers(ArrayList<TreeMap<PropertyIdEnum, String>> users);
	
	/**
	 * Modify the User Object by UserName 
	 * the TreeMap has to use PropertyIdEnum as Key
	 * 
	 * @param userName The user name of the user.
	 * @param userProperties The properties that will be used to modify the user.
	 */
	public abstract void modifyUser(String userName, TreeMap<PropertyIdEnum, String> userProperties);
	
	
	/**
	 * Remove the User Object by UserName 
	 * 
	 * @param userId The user name for the user to be deleted.
	 * @param successState Events.SUCCESS normally, Events.SPECIAL to avoid a feedback loop when deleting accounts.
	 */
	public abstract void deleteUser(String userId, String successState);
	
	/**
	 * Remove the list of User Objects by UserName 
	 * 
	 * @param userIds The usernames for the users to be deleted.
	 */
	public abstract void deleteUsers(ArrayList<String> userIds);
	
	/**
	 * Get the user by its username
	 * 
	 * @param userId The user name for the user that is being looked for.
	 */
	public abstract void getUser(String userId);
	
	/**
	 * Used to Config the Factory
	 * 
	 * @param userFactory The Factory that is being set.
	 */
	public abstract void setManagementFactory(ManagementFactoryIf<UserObjectIf> userFactory);
	
	/**
	 * this method will be triggered once the event changed.
	 * @param evt The event that was received.
	 */
	@Override
	public abstract void propertyChange(PropertyChangeEvent evt);
	
	/**
	 * Adds listeners to this class.
	 *
	 * @param pcl a property change listener
	 */
	public abstract void addPropertyChangeListener(PropertyChangeListener pcl);

	/**
	 * Removes listeners to this class.
	 *
	 * @param pcl a property change listener
	 */
	public abstract void removePropertyChangeListener(PropertyChangeListener pcl);
	
}
