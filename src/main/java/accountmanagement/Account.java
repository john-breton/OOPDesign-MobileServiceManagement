package accountmanagement;

import lombok.Getter;
import lombok.Setter;

/**
 * The Account class represents one of the three main data types used by the various
 * management services in the application. The Account encompasses the other two
 * data types (User and Bundle) alongside a unique phone number to produce a service
 * account. These service accounts are managed by the AccountManagement class.
 */
public class Account {
    /*
     * Gets the username identifier for this Account.
     *
     * @return The username for this Account.
     */
    @Getter
    private final String user;

    /*
     * Gets the phone number for this Account.
     *
     * @return The phone number for this Account, as a String.
     */
    @Getter
    private final String phoneNum;

    /*
     * --GETTER--
     * Gets the bundle name identifier for this Account.
     *
     * @return The bundle name for this Account.
     * <p>
     * --SETTER--
     * Sets the Bundle for this Account
     * @param bundle The bundle name the Account will now be associated with the Account.
     */
    @Getter
    @Setter
    private String bundle;

    /**
     * Construct a new Account based on the passed parameters.
     *
     * @param user     The user String (username identifier) to be associated with the Account (Cannot be modified).
     * @param phoneNum The phone number to be associated with the Account (unique identifier, cannot be modified).
     * @param bundle   The bundle String (bundle name identifier) to be associated with the Account (Can be modified).
     */
    Account(String user, String phoneNum, String bundle) {
        this.user = user;
        this.phoneNum = phoneNum;
        this.bundle = bundle;
    }
}
