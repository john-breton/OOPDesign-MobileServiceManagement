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
    /**
     * Gets the username identifier for this Account.
     *
     * @return The username for this Account.
     */
    @Getter
    private final String user;

    /**
     * Gets the phone number for this Account.
     *
     * @return The phone number for this Account, as a String.
     */
    @Getter
    private final String phoneNum;

    /**
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

    /**
     * Return a formatted String displaying the Account information.
     * TODO Send out signals so the other services print out information about the user based on the
     *      username and the bundle information based on the bundle name. Essentially, this will need
     *      to be completely replaced once the Observer Pattern gets implemented.
     *
     * @return A formatted String that displays the User, phone number, and Bundle info for the service account.
     */
    @Override
    public String toString() {
        String str = "\t\t------ACCOUNT INFO------\n" + String.format("User:\n\t\t%s\n", user) +
                String.format("Phone Number: %s\n", phoneNum) + String.format("Bundle:\n\t\t%s", bundle);
        return str;
    }
}
