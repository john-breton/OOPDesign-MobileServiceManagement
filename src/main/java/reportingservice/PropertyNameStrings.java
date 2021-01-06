package reportingservice;

/**
 * 
 * This final class holds the propertyName strings fired by property events
 * in the ReportingService class and Management classes. 
 * 
 * 
 * @author Matthew Siu
 * @version December 31, 2020
 * @since December 31, 2020
 */
public final class PropertyNameStrings {
	// Various Property Change Strings/Notifications
	public static final String PROPERTY_CHANGE_SCOPE_DELIMITER = "::";
	
	public static final String ACCOUNT = "Account";
	public static final String USER = "User";
	public static final String BUNDLE = "Bundle";
	
	public static final String NEW = "New";
	public static final String UPDATING = "Updating";
	public static final String UPDATED = "Updated";
	public static final String DELETE = "Delete";
	
	// Reporting Service Commands
	public static final String PRINT_ACCOUNT_DETAILS = "printAccountDetails";
	public static final String PRINT_USER_DETAILS = "printUserDetails";
	public static final String PRINT_BUNDLE_DETAILS = "printBundleDetails";

	public static final String PRINT_USER_LIST = "printUserList";
	
	public static final String PRINT_USER_ADDED = "printUserAdded";
	public static final String PRINT_USER_DELETED = "printUserDeleted";
	public static final String PRINT_USER_UPDATING = "printUserUpdating";
	public static final String PRINT_USER_UPDATED = "printUserUpdateed";
	
	public static final String ADD_USER = "addUser";
	public static final String ADD_MULTIPLE_USERS = "addMultipleUsers";
	public static final String DELETE_USER = "deleteUser";
	public static final String DELETE_MULTIPLE_USERS = "deleteMultipleUsers";
	public static final String UPDATE_USER = "updateUser";
	

}
