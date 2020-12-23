package AccountManagement;

public class AccountManagement {
	private static AccountManagement uniqueInstance;
	
	// other instance variables
	
	private AccountManagement() {}
	
	public static synchronized AccountManagement getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new AccountManagement();
		}
		return uniqueInstance;
	}
	
	// other methods
}
