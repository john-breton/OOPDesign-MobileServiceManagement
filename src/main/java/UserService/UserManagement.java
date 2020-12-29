package UserService;
import java.util.ArrayList;

/**
 * A singleton class used to manage users
 * */
public class UserManagement {
	
	private static UserManagement uniqueInstance = new UserManagement();
	private ArrayList<User> users;
	
	//private constructor to make this class singleton
	private UserManagement() {
		users = new ArrayList<User>();
	}
	
	public UserManagement getInstance() {
		return uniqueInstance;
	}
	
}
