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
import reportingservice.PropertyNameStrings.Events;

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
			System.out.println("Incorrect user type in UserManagement");
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
			
			try {
				userId = (String) dict.get("userId");
				if (userId == null) {
					throw new Exception("Error! The user surfoplane is required for add a new user");
				}
				
				String address = (String) dict.get("address");
				String email = (String) dict.get("email");
				
				addUser(userId);
				TreeMap<PropertyIdEnum, String> newUser = new TreeMap<PropertyIdEnum, String>();
				newUser.put(PropertyIdEnum.USER_NAME, userId);
				newUser.put(PropertyIdEnum.USER_ADDRESS, address);
				newUser.put(PropertyIdEnum.USER_EMAIL, email);
				modifyUser(userId,newUser);
				
				//notify the reporting service
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.NEW, Events.SUCCESS.getDesc(), dict);
			}catch (Exception ex) {
				//failed to add new user. notify reporting service
				System.out.println(ex.getMessage());

				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.NEW, Events.FAILURE.getDesc(), dict);
			}
			
			break;
		case PropertyNameStrings.ADD_MULTIPLE_USERS:
			/*
			 * TreeMap:
			 * 	* Key: "users",	Value type: ArrayList<TreeMap> (format as ADD_USER above),	required
			 */
			try {
				Object tempObj = dict.get("users"); 
				if (!(tempObj instanceof ArrayList<?>)) {
					throw new Exception("Incorrect user type in UserManagement");
				}
				
				ArrayList<?> tempList = (ArrayList<?>) evt.getNewValue();
				
				if (!(tempList.get(0) instanceof TreeMap)) {
					throw new Exception("Incorrect user type in UserManagement");
				}
				ArrayList<TreeMap<String, Object>> userList = (ArrayList<TreeMap<String, Object>>) tempList;
				
				//loop through each user in the list
				for(TreeMap<String, Object> currentUser:userList) {
					String currentUserId = (String)currentUser.get("userId");
					String currentAddress = (String)currentUser.get("address");
					String currentEmail = (String)currentUser.get("email");
					if (currentUserId == null) {
						//quit if the user name is not exists
						throw new Exception("Invalid UserID");
					}
					addUser(currentUserId);
					TreeMap<PropertyIdEnum, String> currentNewUser = new TreeMap<PropertyIdEnum, String>();

					currentNewUser.put(PropertyIdEnum.USER_NAME, currentUserId);
					
					if (currentAddress != null) {
						//skip if its not exist
						currentNewUser.put(PropertyIdEnum.USER_ADDRESS, currentAddress);
					}
					
					if (currentEmail != null) {
						//skip if its not exist
						currentNewUser.put(PropertyIdEnum.USER_EMAIL, currentEmail);
					}
					modifyUser(currentUserId,currentNewUser);
				}
				//notify the reporting service
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.NEW, Events.SUCCESS.getDesc(), dict);
			}catch(Exception ex) {
				//failed to add users
				System.out.println(ex.getMessage());

				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.NEW, Events.FAILURE.getDesc(), dict);
			}
			
			break;
		case PropertyNameStrings.DELETE_USER:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 */
			try {
				userId = (String) dict.get("userId");
				if (userId == null) {
					throw new Exception("Error! The user surfoplane is required for removing a user");
				}
				
				deleteUser(userId);
				
				//notify the reporting service
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.DELETE, Events.SUCCESS.getDesc(), dict);
			}catch (Exception ex) {
				System.out.println(ex.getMessage());
				//failed to add new user. notify reporting service
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.DELETE, Events.FAILURE.getDesc(), dict);
			}
			
			break;
		case PropertyNameStrings.UPDATE_USER:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 * 	* Key: "address",	Value type: String,	optional
			 * 	* Key: "email",		Value type: String,	optional
			 */
			try {
				userId = (String) dict.get("userId");
				if (userId == null) {
					throw new Exception("Error! The user surfoplane is required for add a new user");
				}
				
				String address = (String) dict.get("address");
				String email = (String) dict.get("email");
				
				
				//printing a message before the update
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.UPDATING, Events.SUCCESS.getDesc(),dict );
				
				//create the new user
				TreeMap<PropertyIdEnum, String> newUser = new TreeMap<PropertyIdEnum, String>();
				newUser.put(PropertyIdEnum.USER_NAME, userId);
				newUser.put(PropertyIdEnum.USER_ADDRESS, address);
				newUser.put(PropertyIdEnum.USER_EMAIL, email);
				modifyUser(userId,newUser);
				
				//notify the reporting service
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.UPDATED, Events.SUCCESS.getDesc(), dict);
			}catch (Exception ex) {
				//failed to add new user. notify reporting service
				System.out.println(ex.getMessage());

				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.UPDATED, Events.FAILURE.getDesc(), dict);
			}
			
			break;
		case PropertyNameStrings.DELETE_MULTIPLE_USERS:
			/*
			 * TreeMap:
			 * 	* Key: "users",	Value type: ArrayList<String>,	required
			 */
			
			try {
				Object tempObj = dict.get("users"); 
				if (!(tempObj instanceof ArrayList<?>)) {
					throw new Exception("Incorrect user type in UserManagement");
				}
				
				ArrayList<?> tempList = (ArrayList<?>) evt.getNewValue();
				
				if (!(tempList.get(0) instanceof TreeMap)) {
					throw new Exception("Incorrect user type in UserManagement");
				}
				ArrayList<TreeMap<String, Object>> userList = (ArrayList<TreeMap<String, Object>>) tempList;
				
				//loop through each user in the list
				for(TreeMap<String, Object> currentUser:userList) {
					String currentUserId = (String)currentUser.get("userId");
					if (currentUserId == null) {
						//quit if the user name is not exists
						throw new Exception("Invalid UserID");
					}
					deleteUser(currentUserId);
				
				}
				//notify the reporting service
				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.DELETE, Events.SUCCESS.getDesc(), dict);
			}catch(Exception ex) {
				//failed to add users
				System.out.println(ex.getMessage());

				support.firePropertyChange(PropertyNameStrings.USER +
						PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER +
						PropertyNameStrings.DELETE, Events.FAILURE.getDesc(), dict);
			}

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
		case PropertyNameStrings.PRINT_USER_ADDED:
			/*
			 * TreeMap:
			 * 	* <empty> - no parameters required
			 */
			Object currentObj =  dict.get("users");
			
			//if its contains the list of users
			if(currentObj != null && currentObj instanceof ArrayList<?>) {
				ArrayList<?> currentUserList = (ArrayList<?>)currentObj;
				if(evt.getOldValue().equals(Events.FAILURE.getDesc())) {

					System.out.println("Failed to add "+currentUserList.size()+" users.");
				}else {
					userId = (String) dict.get("userId");
					System.out.println(currentUserList.size()+" Users Added!");
				}
			}else {
				//if this is a single user
				
				//if the operation failed
				if(evt.getOldValue().equals(Events.FAILURE.getDesc())) {
					userId = (String) dict.get("userId");
					System.out.println("Failed to add "+ userId + ".");
				}else {
					userId = (String) dict.get("userId");
					System.out.println("The User "+ userId + " Added!");
				}

			}

			break;
			
		case PropertyNameStrings.PRINT_USER_UPDATING:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 */
			userId = (String) dict.get("userId");
			System.out.println("Trying to update User "+ userId + " ");
			printUser(userId);
		break;
		
		case PropertyNameStrings.PRINT_USER_UPDATED:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 */
			if(evt.getOldValue().equals(Events.FAILURE.getDesc())) {
				userId = (String) dict.get("userId");
				System.out.println("Failed to add user "+ userId + ".");
			}else {
				userId = (String) dict.get("userId");
				System.out.println("User "+ userId + " Updated");
				printUser(userId);
			}
			
		break;
		
		case PropertyNameStrings.PRINT_USER_DELETED:
			/*
			 * TreeMap:
			 * 	* Key: "userId",	Value type: String,	required
			 */
			
			Object currentRemovedObj =  dict.get("users");
			
			//if its contains the list of users
			if(currentRemovedObj != null && currentRemovedObj instanceof ArrayList<?>) {
				ArrayList<?> currentUserList = (ArrayList<?>)currentRemovedObj;
				if(evt.getOldValue().equals(Events.FAILURE.getDesc())) {

					System.out.println("Failed to remove "+currentUserList.size()+" users.");
				}else {
					userId = (String) dict.get("userId");
					System.out.println(currentUserList.size()+" Users Removed!");
				}
			}else {
				//if this is a single user
				
				//if the operation failed
				if(evt.getOldValue().equals(Events.FAILURE.getDesc())) {
					userId = (String) dict.get("userId");
					System.out.println("Failed to remove user "+ userId + ".");
				}else {
					userId = (String) dict.get("userId");
					System.out.println("User "+ userId + " Removed");
				}

			}
			
			
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
