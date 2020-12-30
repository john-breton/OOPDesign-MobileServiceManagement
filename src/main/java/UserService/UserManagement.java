package UserService;

import java.util.ArrayList;

/**
 * A singleton class used to manage users
 */
public class UserManagement {

	private static UserManagement uniqueInstance = new UserManagement();
	private ArrayList<User> users;

	// private constructor to make this class singleton
	private UserManagement() {
		users = new ArrayList<User>();
	}

	public UserManagement getInstance() {
		return uniqueInstance;
	}

	public void addUser(User user) {
		int userPosition = findUserPosition(user.getName());
		//make sure there is no duplicate
		if(userPosition == -1) {
			//if user doesnt exists
			users.add(user);
		}
	}

	public void addUsers(ArrayList<User> users) {
		for(User user:users) {
			addUser(user);
		}
	}

	public void deleteUser(User user) {
		// get the name of the user
		String userName = user.getName();
		deleteUser(userName);
	}

	public void deleteUser(String userName) {

		int targetLocation = findUserPosition(userName);

		if (targetLocation == -1) {
			// target not found, do nothing
			return;
		} else {
			users.remove(targetLocation);
		}
	}

	public void deleteUsers(ArrayList<String> userNameArr) {
		for (String currentUserName : userNameArr) {
			// remove the current user from the list
			deleteUser(currentUserName);

//	#TODO also need to remove all related information
		}
	}

	public void updateUser(User user) {
		// need to be modified once the user is done
		String userName = user.getName();

		int targetLocation = findUserPosition(userName);

		if (targetLocation == -1) {
			// do nothing if user not found
		} else {
//			deleteUser(userName);
//			addUser(user);
//			#TODO only update the email and address can be updated
		}

	}

	public User getUser(String userName) {
		int targetLocation = findUserPosition(userName);
		if (targetLocation == -1)
			// user not found
			return null;
		else
			return users.get(targetLocation);
	}

	private int findUserPosition(String userName) {
		// find the target user
		int targetLocation = -1;
		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).getName().equals(userName)) {
				// target found, skip the loop
				targetLocation = i;
				break;
			}
		}
		return targetLocation;
	}

}
