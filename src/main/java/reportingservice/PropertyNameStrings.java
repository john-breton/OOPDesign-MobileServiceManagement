package reportingservice;

/**
 * This final class holds the propertyName strings fired by property events
 * in the ReportingService class and Management classes.
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
    public static final String DISPLAY = "Display";

    // Reporting Service Commands
    public static final String PRINT_ACCOUNT_DETAILS = "printAccountDetails";
    public static final String PRINT_ACCOUNT_ADDED = "printAccountAdded";
    public static final String PRINT_ACCOUNT_DELETED = "printAccountDeleted";
    public static final String PRINT_USER_DETAILS = "printUserDetails";
    public static final String DELETE_USER = "deleteUser";
    public static final String PRINT_BUNDLE_DETAILS = "printBundleDetails";

    /**
     * Enum used to simplify event passing.
     */
    public enum Events {
        SUCCESS("success"),
        FAILURE("failure"),
        SPECIAL("special"),
        USER("user"),
        BUNDLE("bundle"),
        ACCOUNT("account");

        private String desc;

        Events(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

}
