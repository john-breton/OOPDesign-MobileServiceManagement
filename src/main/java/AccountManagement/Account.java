package AccountManagement;

import lombok.Getter;
import lombok.Setter;

import java.io.StringReader;

/**
 * The Account class represents one of the three main data types used by the various
 * management services in the application. The Account encompasses the other two
 * data types (User and Bundle) alongside a unique phone number to produce a service
 * account. These service accounts are managed by the AccountManagement class.
 */
public class Account {
    /**
     * Gets the User object for this Account.
     *
     * @return The User for this Account.
     */
    @Getter
    private User user;

    /**
     * Gets the phone number for this Account.
     *
     * @return The phone number for this Account, as a String.
     */
    @Getter
    private String phoneNum;

    /**
     * --GETTER--
     * Gets the Bundle for this Account.
     *
     * @return The Bundle for this Account.
     * <p>
     * --SETTER--
     * Sets the Bundle for this Account
     * @param bundle The Bundle object the Account will now be associated with the Account.
     */
    @Getter
    @Setter
    private Bundle bundle;

    /**
     * Construct a new Account based on the passed parameters.
     *
     * @param user     The User object to be associated with the Account (Cannot be modified).
     * @param phoneNum The phone number to be associated with the Account (unique identifier, cannot be modified).
     * @param bundle   The Bundle object to be associated with the Account (Can be modified).
     */
    Account(User user, String phoneNum, Bundle bundle) {
        this.user = user;
        this.phoneNum = phoneNum;
        this.bundle = bundle;
    }

    /**
     * Return a formatted String displaying the Account information.
     *
     * @return A formatted String that displays the User, phone number, and Bundle info for the service account.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\t\t------ACCOUNT INFO------\n").append(String.format("User:\n\t\t%s\n", user))
                .append(String.format("Phone Number: %s\n", phoneNum)).append(String.format("Bundle:\n\t\t%s", bundle));
        return str.toString();
    }
}
