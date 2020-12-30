package reportingService;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This is a concrete implementation of the Reporting Service. It is both an
 * observer and observable. It fulfills the automatic reports requirement.
 * 
 * The class listens for changes in the management classes, and will respond by
 * sending out commands to the management classes in order to have them print
 * out information.
 * 
 * This class adds/removes observers (PropertyChangeListeners) who listen for
 * its commands. For the midterm, these listeners would be the management
 * services.
 * 
 * In order to expand this class, PropertyChangeEvent propertyNames must meet
 * the required formatting:
 * 
 * propertyNames from Management classes should be in the format of:
 * 
 * "ManagementType::DetailType"
 * 
 * e.g. "Account::New" propertyNames
 * 
 * 
 * 
 * @author Matthew Siu
 * @version December 30, 2020
 * @since December 30, 2020
 *
 */

public class ConcreteReportingService implements PropertyChangeListener {

	private PropertyChangeSupport support;

	/**
	 * Constructor for ConcreteReportingService.
	 */
	public ConcreteReportingService() {
		support = new PropertyChangeSupport(this);
	}

	/**
	 * Adds listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	/**
	 * This method is called whenever a management service has a special change
	 * (e.g. new account, updating user, new bundle)
	 * 
	 * It will respond by sending out the corresponding command to its listeners
	 * 
	 * @param event an event from the management classes indicating the change
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// property should be in format of "ManagementType::DetailType"
		// e.g. "Account::New"
		String property = event.getPropertyName();
		String managementType = property.substring(0, property.indexOf("::"));
		String detailType = property.substring(property.indexOf("::") + 2);

		if (managementType.equals("Account")) {
			if (detailType.equals("New")) {
				support.firePropertyChange("printAccountDetails", false, true);
			}
			if (detailType.equals("Updating")) {
				support.firePropertyChange("printAccountDetails", false, true);
			}
			if (detailType.equals("Updated")) {
				support.firePropertyChange("printAccountDetails", false, true);
			}
			if (detailType.equals("Delete")) {
				support.firePropertyChange("printAccountDetails", false, true);
			}
		}
		if (managementType.equals("User")) {
			if (detailType.equals("New")) {
				support.firePropertyChange("printUserDetails", false, true);
			}
			if (detailType.equals("Update")) {
				support.firePropertyChange("printUserDetails", false, true);
			}
			if (detailType.equals("Updated")) {
				support.firePropertyChange("printUserDetails", false, true);
			}
			if (detailType.equals("Delete")) {
				support.firePropertyChange("printUserDetails", false, true);
			}
		}
		if (managementType.equals("Bundle")) {
			if (detailType.equals("New")) {
				support.firePropertyChange("printBundleDetails", false, true);
			}
		}
	}
}
