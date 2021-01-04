package services;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ReportingService.ReportToService;
import properties.PropertyIdEnum;
import users.UserObjectIf;
import users.UserManagementFactory;

/**
 * A singleton class used to manage users
 */
public class UserManagement implements ReportToService {

	private static UserManagement uniqueInstance = new UserManagement();
	private TreeMap<String, UserObjectIf> users;
	private ManagementFactoryIf<UserObjectIf> userFactory;

	// private constructor to make this class singleton
	private UserManagement() {
		users = new TreeMap<String, UserObjectIf>();
		userFactory = new UserManagementFactory();
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
		for (Map.Entry<String, UserObjectIf> user : users.entrySet()) {
			System.out.println(user.toString());
		}
		
		System.out.println("");
	}
}
