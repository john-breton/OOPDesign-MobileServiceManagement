package UserService;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import ReportingService.ReportToService;

/**
 * A singleton class used to manage users
 */
public class UserManagement implements ReportToService {

	private static UserManagement uniqueInstance = new UserManagement();
//	private ArrayList<User> users;
	private TreeMap<String, UserObjectIf> users;

	// private constructor to make this class singleton
	private UserManagement() {
//		users = new ArrayList<User>();
		users = new TreeMap<String, UserObjectIf>();
	}

	public static UserManagement getInstance() {
		return uniqueInstance;
	}

	public void addUser(UserObjectIf user) {
		if (!users.containsKey(user.getId())) {
			users.put(user.getId(), user);
		}
		
//		int userPosition = findUserPosition(user.getName());
//		
//		// make sure there is no duplicate
//		if (userPosition == -1) {
//			// if user doesnt exists
//			users.add(user);
//		}
	}

	public void addUsers(ArrayList<UserObjectIf> users) {
		for (UserObjectIf user : users) {
			addUser(user);
		}
	}

	public void deleteUser(UserObjectIf user) {
		// get the name of the user
		String userName = user.getId();
		deleteUser(userName);
	}

	public void deleteUser(String userName) {
		if (users.containsKey(userName)) {
			users.remove(userName);
		}

//		int targetLocation = findUserPosition(userName);
//
//		if (targetLocation == -1) {
//			// target not found, do nothing
//			return;
//		} else {
//			users.remove(targetLocation);
//		}
	}

	public void deleteUsers(ArrayList<String> userNameArr) {
		for (String currentUserName : userNameArr) {
			// remove the current user from the list
			deleteUser(currentUserName);

//	#TODO also need to remove all related information
		}
	}

	// #TODO Do we want to expose the UserObjectIf to whoever has an instance
	//	of this class? If not, let's remove this
	public void updateUser(UserObjectIf user) {
		// need to be modified once the user is done
		String userName = user.getId();
		
		if (!users.containsKey(user)) {
			// do nothing user not found
			// #TODO should bubble this up to UI - exception possibly?
			return;
		}
		 
		UserObjectIf oldUser = users.put(userName, user);
		System.out.println("Replacing old user: " + oldUser.toString());
		System.out.println("New user: " + user.toString());

//		int targetLocation = findUserPosition(userName);
//
//		if (targetLocation == -1) {
//			// do nothing if user not found
//		} else {
////			deleteUser(userName);
////			addUser(user);
////			#TODO only update the email and address can be updated
//		}
	}

	public UserObjectIf getUser(String userName) {
		return users.get(userName);
		
//		int targetLocation = findUserPosition(userName);
//		if (targetLocation == -1)
//			// user not found
//			return null;
//		else
//			return users.get(targetLocation);
	}

//	private int findUserPosition(String userName) {
//		// find the target user
//		int targetLocation = -1;
//		for (int i = 0; i < users.size(); i++) {
//
//			if (users.get(i).getName().equals(userName)) {
//				// target found, skip the loop
//				targetLocation = i;
//				break;
//			}
//		}
//		return targetLocation;
//	}
	
	// New methods below...
	
	public void addUser(String name) {
		// TODO: We could use a simple factory here to create the new
		//	UserObjects, allowing us to use UserObjectIf everywhere in this
		//	class.
		users.put(name, new UserObject(name));
	}
	
	public void modifyUser(String userName, TreeMap<PropertyIdEnum, String> userProperties) {
		if (!users.containsKey(userName)) {
			System.out.println("Cannot find user with username: " + userName);
			return;
		}
		
		users.get(userName).modifyProperties(userProperties);
	}
	
	public void printAllUsers() {
		for (Map.Entry<String, UserObjectIf> user : users.entrySet()) {
			System.out.println(user.toString());
		}
		
		System.out.println("");
	}
}
