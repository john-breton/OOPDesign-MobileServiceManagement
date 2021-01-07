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

    public static final String ACCOUNT = "ACCOUNT";
    public static final String USER = "USER";
    public static final String BUNDLE = "BUNDLE";

    public static final String NEW = "NEW";
    public static final String UPDATING = "UPDATING";
    public static final String UPDATED = "UPDATED";
    public static final String DELETE = "DELETE";
    public static final String DISPLAY = "DISPLAY";

    // Reporting Service Commands
    public static final String PRINT_ACCOUNT_DETAILS = "PRINT_ACCOUNT_DETAILS";
    public static final String PRINT_ACCOUNT_ADDED = "PRINT_ACCOUNT_ADDED";
    public static final String PRINT_ACCOUNT_DELETED = "PRINT_ACCOUNT_DELETED";
    public static final String PRINT_USER_DETAILS = "PRINT_USER_DETAILS";
    public static final String PRINT_USER_LIST = "PRINT_USER_LIST";
    public static final String PRINT_USER_ADDED = "PRINT_USER_ADDED";
    public static final String PRINT_USER_UPDATING = "PRINT_USER_UPDATING";
    public static final String PRINT_USER_UPDATED = "PRINT_USER_UPDATED";
    public static final String PRINT_USER_DELETED = "PRINT_USER_DELETED";
    public static final String DELETE_USER = "DELETE_USER";
    public static final String PRINT_BUNDLE_DETAILS = "PRINT_BUNDLE_DETAILS";

    /**
     * Enum used to simplify event passing.
     */
    public enum Events {
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE"),
        SPECIAL("SPECIAL");

        private String desc;

        Events(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

}
