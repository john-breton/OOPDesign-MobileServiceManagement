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
import reportingservice.PropertyNameStrings;

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

	private void addUser(UserObjectIf user) {
		if (!users.containsKey(user.getId())) {
			users.put(user.getId(), user);
		}
	}

	private void addUsers(ArrayList<UserObjectIf> users) {
		for (UserObjectIf user : users) {
			addUser(user);
		}
	}

	private void deleteUser(UserObjectIf user) {
		// get the ID of the user
		String userId = user.getId();
		deleteUser(userId);
	}

	private void deleteUser(String userId) {
		if (users.containsKey(userId)) {
			users.remove(userId);
		}
	}

	private void deleteUsers(ArrayList<String> userIds) {
		for (String userId : userIds) {
			// remove the current user from the list
			deleteUser(userId);

			// TODO also need to remove all related information
		}
	}

	// #TODO Do we want to expose the UserObjectIf (and by extension, the UserObject) class to whoever has an instance of this class? If not, let's remove this
	private void updateUser(UserObjectIf user) {
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

	private UserObjectIf getUser(String userId) {
		return users.get(userId);
	}
	
	// New methods below...
	
	private void addUser(String name) {
		users.put(name, userFactory.createObjectById(name));
	}
	
	private void modifyUser(String userName, TreeMap<PropertyIdEnum, String> userProperties) {
		if (!users.containsKey(userName)) {
			System.out.println("Cannot find user with username: " + userName);
			return;
		}

		users.get(userName).modifyProperties(userProperties);
	}
	
	public void setManagementFactory(ManagementFactoryIf<UserObjectIf> userFactory) {
		this.userFactory = userFactory;
	}
	
	private void printAllUsers() {
		for (Map.Entry<String, UserObjectIf> user : users.entrySet()) {
			System.out.println(user.toString());
		}
		
		System.out.println("");
	}
	
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
	
	private void printUser(String userId) {
		UserObjectIf user = users.get(userId);
		
		if (user == null) {
			// TODO: Can't find user - print error message.
			return;
		}
		
		System.out.println(user.toString());
	}
	
	/* addUser <userName> <userAddress> <userEmail> */

	public void propertyChange(PropertyChangeEvent evt) {
		/*
		 * Assumptions:
		 * 	* evt.getPropertyName() holds the event to handle
		 * 	* evt.getOldValue() holds SUCCESS or FAILURE
		 * 	* evt.getNewValue() holds a TreeMap containing the necessary details
		 * 		(each case-branch below has a comment indicating what key(s) it needs
		 * 		and the expected type of the value(s) for that/those key(s))
		 */
		if (!(evt.getNewValue() instanceof TreeMap<?,?>)) {
			// TODO: print error?
			return;
		}
		TreeMap<String, Object> dict = (TreeMap<String, Object>) evt.getNewValue();
		String userId;
		
		System.out.println("User property change");
		
		switch (evt.getPropertyName()) {
		case PropertyNameStrings.ADD_USER:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 * 	* Key: "address",	Value type: String,	optional
			 * 	* Key: "email",		Value type: String,	optional
			 */
			userId = (String) dict.get("userId");
			if (userId == null) {
				// TODO: print error
				return;
			}
			
			String address = (String) dict.get("address");
			String email = (String) dict.get("email");
			
			addUser(userId);
			
			// TODO Address and Email
			
			TreeMap<String,Object> newDict = new TreeMap<String, Object>();
			dict.put("userId", userId);
			
			System.out.println("User added");
			
			support.firePropertyChange(PropertyNameStrings.USER +
					PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
					PropertyNameStrings.NEW, new TreeMap<String, Object>(), newDict);
			break;
		case PropertyNameStrings.ADD_MULTIPLE_USERS:
			/*
			 * TreeMap:
			 * 	* Key: "users",	Value type: ArrayList<TreeMap> (format as ADD_USER above),	required
			 */
			break;
		case PropertyNameStrings.DELETE_USER:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 */
			break;
		case PropertyNameStrings.UPDATE_USER:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 * 	* Key: "address",	Value type: String,	optional
			 * 	* Key: "email",		Value type: String,	optional
			 */
			break;
		case PropertyNameStrings.DELETE_MULTIPLE_USERS:
			/*
			 * TreeMap:
			 * 	* Key: "userIds",	Value type: ArrayList<String>,	required
			 */
			userId = (String) dict.get("userId");
			deleteUser(userId);
			break;
		case PropertyNameStrings.PRINT_USER_DETAILS:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 */
			userId = (String) dict.get("userId");
			printUser(userId);
			break;
		case PropertyNameStrings.PRINT_USER_LIST:
			/*
			 * TreeMap:
			 * 	* <empty> - no parameters required
			 */
			printAllUserNames();
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
		System.out.println("[USER] Added property change listener");
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		System.out.println("[USER] Removed property change listener");
		support.removePropertyChangeListener(pcl);
	}
}
