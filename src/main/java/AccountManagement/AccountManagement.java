package AccountManagement;


/**
 * The AccountManagement class is responsible for managing accounts
 * that belong to the overall system. An Account is composed of a User,
 * a Bundle, and a phone number.
 *
 * The AccountManagement class will maintain a list of Accounts in order
 * to perform management operations such as adding, deleting, or modifying
 * an existing account.
 *
 * AccountManagement is a Singleton. This means that the class contains a
 * private constructor and ensures that only one instance of the class will
 * exist at any given time. This is to prevent data corruption once it comes
 * to multiple admins making use of the AccountManagement service.
 */
public class AccountManagement {
	// We will always need an AccountManagement instance, so use eager instantiation.
	private static AccountManagement uniqueInstance = new AccountManagement();

	private AccountManagement() {}

	/**
	 * Get the AccountManagement instance.
	 *
	 * @return The Singleton instance of the AccountManagement class.
	 */
	public static AccountManagement getInstance() {
		return uniqueInstance;
	}

	/**
	 *
	 * @param user
	 * @param phoneNum
	 * @param bundle
	 */
	public void addAccount(User user, String phoneNum, Bundle bundle) {
		return;
	}

	/**
	 *
	 * @param acc
	 */
	public void addAccount(Account acc) {
		return;
	}

	/**
	 *
	 * @param phoneNum
	 */
	public void removeAccount(String phoneNum) {
		return;
	}

	/**
	 *
	 * @param phoneNum
	 * @param bundle
	 */
	public void updateAccount(String phoneNum, Bunble bundle) {
		return;
	}

	/**
	 *
	 * @param phoneNum
	 * @return
	 */
	public Account getAccount(String phoneNum) {
		return null;
	}

	/**
	 * 
	 * @param phoneNum
	 * @param bundle
	 */
	public void updateBundle(String phoneNum, Bundle bundle) {
		return;
	}

}
