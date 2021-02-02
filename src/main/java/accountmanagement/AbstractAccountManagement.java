package accountmanagement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This is an abstract class for the AccountManagement class
 * @author esiumat
 *
 */
public abstract class AbstractAccountManagement implements PropertyChangeListener {
	
    /**
     * Add a new service account based on the passed in parameters. This
     * requires a User and Bundle object to have already been created and
     * instantiated previously. The phone number is required to be unique,
     * as a specific phone number can only be associated with a single account.
     *
     * @param user     The username identifier that will belong to the account.
     * @param phoneNum The phone number that will be associated with an account.
     *                 Required to be unique, as a specific phone number can
     *                 only be associated with a single account.
     * @param bundle   The bundle name identifier that will belong to the account.
     */
    public abstract void addAccount(String user, String phoneNum, String bundle);

	/**
     * Makes an attempt to delete a user if the deleted account was the last
     * account said user was associated with.
     *
     * @param phoneNum The phone number for the service account being removed, as a String.
     */
    public abstract void removeAccount(String phoneNum);
    
    /**
     * Update the bundle associated with a service account.
     *
     * @param phoneNum The phone number of the service account that is being updated.
     * @param bundle   The new bundle name identifier that is being associated with the service account.
     */
    public abstract void updateAccountBundle(String phoneNum, String bundle);
    
    /**
	 *Handle the various event from ReportingService. Any unknown
     * events are ignored.
     * @param evt an event from ReportingService indicating the change
	 */
	@Override
	public abstract void propertyChange(PropertyChangeEvent evt);
	
	/**
	 * Adds listeners to this class.
	 *
	 * @param pcl a property change listener
	 */
	public abstract void addPropertyChangeListener(PropertyChangeListener pcl);

}
