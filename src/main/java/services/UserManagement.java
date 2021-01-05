package services;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import users.UserObjectIf;
import users.UserManagementFactory;
import static reportingservice.PropertyNameStrings.*;

/**
 * A singleton class used to manage users
 */
public class UserManagement  implements PropertyChangeListener {

	private PropertyChangeSupport support;
	private static UserManagement uniqueInstance = new UserManagement();
	private TreeMap<String, UserObjectIf> users;
	private ManagementFactoryIf<UserObjectIf> userFactory;

	// private constructor to make this class singleton
	private UserManagement() {
		users = new TreeMap<String, UserObjectIf>();
		userFactory = new UserManagementFactory();
		support = new PropertyChangeSupport(this);
	}

	public static UserManagement getInstance() {
		return uniqueInstance;
	}

	public void addUser(UserObjectIf user) {
		if (!users.containsKey(user.getId())) {
			users.put(user.getId(), user);
		}
	}

	public void addUsers(ArrayList<UserObjectIf> users) {
		for (UserObjectIf user : users) {
			addUser(user);
		}
	}

	public void deleteUser(UserObjectIf user) {
		// get the ID of the user
		String userId = user.getId();
		deleteUser(userId);
	}

	public void deleteUser(String userId) {
		if (users.containsKey(userId)) {
			users.remove(userId);
		}
	}

	public void deleteUsers(ArrayList<String> userIds) {
		for (String userId : userIds) {
			// remove the current user from the list
			deleteUser(userId);

			// TODO also need to remove all related information
		}
	}

	// #TODO Do we want to expose the UserObjectIf (and by extension, the UserObject) class to whoever has an instance of this class? If not, let's remove this
	public void updateUser(UserObjectIf user) {
		// need to be modified once the user is done
		String userId = user.getId();
		
		if (!users.containsKey(userId)) {
			// do nothing user not found
			// #TODO should bubble this up to UI - exception possibly?
			return;
		}
		 
		UserObjectIf oldUser = users.put(userId, user);
		System.out.println("Replacing old user: " + oldUser.toString());
		System.out.println("New user: " + user.toString());
	}

	public UserObjectIf getUser(String userId) {
		return users.get(userId);
	}
	
	// New methods below...
	
	public void addUser(String name) {
		users.put(name, userFactory.createObjectById(name));
	}
	
	public void modifyUser(String userName, TreeMap<PropertyIdEnum, String> userProperties) {
		if (!users.containsKey(userName)) {
			System.out.println("Cannot find user with username: " + userName);
			return;
		}

		users.get(userName).modifyProperties(userProperties);
	}
	
	public void setManagementFactory(ManagementFactoryIf<UserObjectIf> userFactory) {
		this.userFactory = userFactory;
	}
	
	public void printAllUsers() {
		System.out.println("Printing All Users");
		System.out.println("-------------------------------------------------------------------------------");

		for (Map.Entry<String, UserObjectIf> user : users.entrySet()) {
			System.out.println(user.toString());
		}
		
		System.out.println("-------------------------------------------------------------------------------");
	}

	public void propertyChange(PropertyChangeEvent event) {
		String currentProperty 	= event.getPropertyName();
		Object oldObj 	  		= event.getOldValue();
		Object currentObj 		= event.getNewValue();
		
		if(currentObj instanceof UserObjectIf) {
			UserObjectIf oldUser = null;
			
			if (oldObj instanceof UserObjectIf)
				oldUser = (UserObjectIf) oldObj;
				
			UserObjectIf currentUser = (UserObjectIf) currentObj;
			switch (currentProperty) {
			case PRINT_USER_ADDED:
				System.out.println("The User "+ currentUser.getId() + " Added!");
				printAllUsers();
			break;
			
			case PRINT_USER_UPDATING:
				System.out.println("Trying to update User "+ currentUser.getId() + " ");
				
				if (oldUser != null) {
					System.out.println("Updating User From: ");
					oldUser.toString();
					System.out.println("To:  ");
				}
				currentUser.toString();
			break;
			
			case PRINT_USER_UPDATED:
				System.out.println("User "+ currentUser.getId() + " Updated");
				
				if (oldUser != null) {
					System.out.println("User updated From: ");
					oldUser.toString();
					System.out.println("To:  ");
				}
				currentUser.toString();
				
				printAllUsers();
			break;
			
			case PRINT_USER_DELETED:
			break;
			}
		}
		else 
		{
			//wrong object found, return
			return;
		}
		
	}
	
	/**
	 * Adds listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
}
