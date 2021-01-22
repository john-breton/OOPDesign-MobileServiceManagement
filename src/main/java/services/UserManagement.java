package services;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import properties.PropertyIdEnum;
import reportingservice.PropertyNameStrings;
import users.UserObjectIf;
import users.UserManagementFactory;

/**
 * A singleton class used to manage user objects
 * @author David,Chen
 * @version 1.0
 */
public class UserManagement extends UserManagement_Abstract {
	
	private static final ArrayList<String> USER_MANAGEMENT_EVENTS = new ArrayList<String>() {
		{
			add(PropertyNameStrings.DELETE_USER);
			add(PropertyNameStrings.PRINT_USER_ADDED);
			add(PropertyNameStrings.PRINT_USER_DELETED);
			add(PropertyNameStrings.PRINT_USER_DETAILS);
			add(PropertyNameStrings.PRINT_USER_LIST);
			add(PropertyNameStrings.PRINT_USER_UPDATED);
			add(PropertyNameStrings.PRINT_USER_UPDATING);
		}
	};
	
	private static final String USER_ID_KEY = "userId";

	private PropertyChangeSupport support;
	private static UserManagement UNIQUE_INSTANCE = new UserManagement();
	private TreeMap<String, UserObjectIf> users;
	private ManagementFactoryIf<UserObjectIf> userFactory;

	/**
	 * private constructor to make this class singleton
	 * */ 
	private UserManagement() {
		users = new TreeMap<String, UserObjectIf>();
		userFactory = new UserManagementFactory();
		support = new PropertyChangeSupport(this);
	}
	
	/**
	 * getInstance method used to get the instance of the current singleton class
	 * @return UserManagement This returns the singleton instance of UserManagement
	 * */
	public static UserManagement getInstance() {
		return UNIQUE_INSTANCE;
	}
	
	/**
	 * Add a single user by name, it will set the attributes empty string by default
	 * @param name (Surfoplane) The user name of the user to be added
	 */
	public void addUser(String name) {
		if (name == null || name.isBlank() || users.containsKey(name)) {
			support.firePropertyChange(
					PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.NEW,
					PropertyNameStrings.Events.FAILURE.getDesc(),
					name);
			return;
		}
		
		users.put(name, userFactory.createObjectById(name));
		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.NEW,
				PropertyNameStrings.Events.SUCCESS.getDesc(),
				name);
	}
	
	/**
	 * Overloaded Method
	 * Add a single user by name and filling the parameters to the user object
	 * @param name (Surfoplance) The username for the user.
	 * @param address The address for the user.
	 * @param email address The email for the user.
	 */
	public void addUser(String name, String address, String email) {
		addUser(name);
		TreeMap<PropertyIdEnum, String> attr = new TreeMap<PropertyIdEnum, String>();
		if (address != null)
			attr.put(PropertyIdEnum.USER_ADDRESS, address);
		else
			attr.put(PropertyIdEnum.USER_ADDRESS, "");
		
		if (email != null)
			attr.put(PropertyIdEnum.USER_EMAIL, email);
		else
			attr.put(PropertyIdEnum.USER_EMAIL, "");

		modifyUser(name, attr);
	}
	
	/**
	 * Add a list of users in to the system. 
	 * the TreeMap has to use PropertyIdEnum as Key
	 * 
	 * @param users The list of users
	 */
	public void addUsers(ArrayList<TreeMap<PropertyIdEnum, String>> users) {
		for (TreeMap<PropertyIdEnum, String> currentUser:users) {
			String currentName = currentUser.get(PropertyIdEnum.USER_NAME);
			String address = currentUser.get(PropertyIdEnum.USER_ADDRESS);
			String email = currentUser.get(PropertyIdEnum.USER_EMAIL);

			addUser(currentName,address,email);
		}
	}
	
	/**
	 * Modify the User Object by UserName 
	 * the TreeMap has to use PropertyIdEnum as Key
	 * 
	 * @param userName The user name of the user.
	 * @param userProperties The properties that will be used to modify the user.
	 */
	public void modifyUser(String userName, TreeMap<PropertyIdEnum, String> userProperties) {
		if (!users.containsKey(userName)) {
			System.out.println("Cannot find user with username: " + userName);
			support.firePropertyChange(
					PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.UPDATED,
					PropertyNameStrings.Events.FAILURE.getDesc(),
					userName);
			return;
		}

		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.UPDATING,
				PropertyNameStrings.Events.SUCCESS.getDesc(),
				userName);
		
		users.get(userName).modifyProperties(userProperties);
		
		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.UPDATED,
				PropertyNameStrings.Events.SUCCESS.getDesc(),
				userName);
	}

	/**
	 * Remove the User Object by UserName 
	 * 
	 * @param userId The user name for the user to be deleted.
	 */
	public void deleteUser(String userId) {
		if (!users.containsKey(userId)) {
			support.firePropertyChange(
					PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DELETE,
					PropertyNameStrings.Events.FAILURE.getDesc(),
					userId);
			return;
		}
		
		users.remove(userId);
		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DELETE,
				PropertyNameStrings.Events.SUCCESS.getDesc(),
				userId);
	}

	/**
	 * Remove the list of User Objects by UserName 
	 * 
	 * @param userIds The usernames for the users to be deleted.
	 */
	public void deleteUsers(ArrayList<String> userIds) {
		for (String userId : userIds) {
			// remove the current user from the list
			deleteUser(userId);
		}
	}

	/**
	 * Get the user by its username
	 * 
	 * @param userId The user name for the user that is being looked for.
	 */
	public void getUser(String userId) {
		if (!users.containsKey(userId)) {
			support.firePropertyChange(
					PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DISPLAY,
					PropertyNameStrings.Events.FAILURE.getDesc(),
					userId);
			return;
		}

		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DISPLAY,
				PropertyNameStrings.Events.SUCCESS.getDesc(),
				userId);
	}
	
	/**
	 * Used to Config the Factory
	 * 
	 * @param userFactory The Factory that is being set.
	 */
	public void setManagementFactory(ManagementFactoryIf<UserObjectIf> userFactory) {
		this.userFactory = userFactory;
	}
	
	/**
	 * printing all users
	 */
	private void printAllUserNames() {
		/*
		 * Even though the "users" TreeMap is indexed by the user's name, we explicitly
		 * get the user's name via the UserObjectIf (i.e. program to implementation) in case
		 * user's are indexed by a different property in the future (e.g. index by some auto-
		 * generated DB GUID).
		 */
		for (Map.Entry<String, UserObjectIf> user : users.entrySet()) {
			System.out.println(user.getValue().getUserName());
		}
	}
	
	/**
	 * printing a single user
	 */
	private void printUser(String userId) {
		UserObjectIf user = users.get(userId);

		System.out.println(user.toString());
	}
	
	/**
	 * this method will be triggered once the event changed.
	 * @param evt The event that was received.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		
		// Ignore event if not applicable to user service
		if (!USER_MANAGEMENT_EVENTS.contains(propertyName)) {
			return;
		}

		TreeMap<String, Object> dict = new TreeMap<String, Object>();
		
		if (evt.getNewValue() instanceof TreeMap<?, ?>) {
			dict = (TreeMap<String, Object>) evt.getNewValue();
		}
		else {
			// If event is not a treeMap, assume event is firing on userId
			dict.put(USER_ID_KEY, evt.getNewValue());
		}
		
		boolean success = evt.getOldValue().equals(PropertyNameStrings.Events.SUCCESS.getDesc());
		
		// Declare variables common to multiple branches here.
		String userId;
		userId = (String) dict.get(USER_ID_KEY);

		System.out.println("User property change");

		switch (propertyName) {
		case PropertyNameStrings.DELETE_USER:
			if (!users.containsKey(userId)) {
				System.out.println("User does not exist!: " + userId);
				return;
			}
			
			deleteUser(userId);
			break;
			
		case PropertyNameStrings.PRINT_USER_DETAILS:
			if (!users.containsKey(userId)) {
				System.out.println("User does not exist!: " + userId);
				return;
			}

			System.out.println("Details for user: " + userId);
			printUser(userId);
			break;
			
		case PropertyNameStrings.PRINT_USER_LIST:
			System.out.println("All user names:");
			printAllUserNames();
			break;
			
		case PropertyNameStrings.PRINT_USER_ADDED:
			if (!users.containsKey(userId)) {
				System.out.println("User does not exist!: " + userId);
				return;
			}
			
			System.out.println("New user added:");
			printUser(userId);

			break;

		case PropertyNameStrings.PRINT_USER_UPDATING:
			if (!users.containsKey(userId)) {
				System.out.println("User does not exist!: " + userId);
				return;
			}
			
			System.out.println("Trying to update User " + userId + " ");
			printUser(userId);
			break;

		case PropertyNameStrings.PRINT_USER_UPDATED:
			if (!users.containsKey(userId)) {
				System.out.println("User does not exist!: " + userId);
				return;
			}
			
			if (success) {
				System.out.println("User " + userId + " Updated");
				printUser(userId);
			} else {
				System.out.println("Failed update to user " + userId + ".");
			}

			break;

		case PropertyNameStrings.PRINT_USER_DELETED:
			System.out.println("Removed user: " + userId);
			break;

		default:
			break;
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


