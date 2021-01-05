package reportingservice;


import java.util.TreeMap;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import static reportingservice.PropertyNameStrings.*;

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
 * @version December 31, 2020
 * @since December 30, 2020
 *
 */

public class ConcreteReportingService implements PropertyChangeListener {

	private static ConcreteReportingService uniqueInstance = new ConcreteReportingService();
	private PropertyChangeSupport support;

	/**
	 * Constructor for ConcreteReportingService.
	 */
	private ConcreteReportingService() {
		support = new PropertyChangeSupport(this);
	}

	/**
	 * getInstance method to ensure this class is a singleton
	 */
	public static ConcreteReportingService getInstance() {
		return uniqueInstance;
	}

	/**
	 * Adds listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		System.out.println("[REPORT] Added property change listener");
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Removes listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		System.out.println("[REPORT] Removed property change listener");
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
	public void propertyChange(PropertyChangeEvent event) {
		// property should be in format of "ManagementType::DetailType"
		// e.g. "Account::New"
		String property = event.getPropertyName();
		String managementType = property.substring(0, property.indexOf(PROPERTY_CHANGE_SCOPE_DELIMITER));
		String detailType = property.substring(
				property.indexOf(PROPERTY_CHANGE_SCOPE_DELIMITER) + PROPERTY_CHANGE_SCOPE_DELIMITER.length());

		System.out.println("Reporting property change");
		
		if (managementType.equals(ACCOUNT)) {
			switch (detailType) {
			case NEW:
			case UPDATING:
			case UPDATED:
			case DELETE:
				support.firePropertyChange(PRINT_ACCOUNT_DETAILS, false, true);
				break;
			default:
				break;
			}
		}
		if (managementType.equals(USER)) {
			switch (detailType) {
			case NEW:
				System.out.println("New user added!");
				support.firePropertyChange(PRINT_USER_DETAILS, event.getOldValue(), event.getNewValue());
				break;
			case UPDATING:
				support.firePropertyChange(PRINT_USER_DETAILS, event.getOldValue(), event.getNewValue());
				break;
			case UPDATED:
				support.firePropertyChange(PRINT_USER_DETAILS, event.getOldValue(), event.getNewValue());
				break;
			case DELETE:
				support.firePropertyChange(PRINT_USER_DETAILS, event.getOldValue(), event.getNewValue());
				break;
			default:
				break;
			}
		}
		if (managementType.equals(BUNDLE)) {
			if (detailType.equals(NEW)) {
				support.firePropertyChange(PRINT_BUNDLE_DETAILS, false, true);
			}
		}
	}
}
