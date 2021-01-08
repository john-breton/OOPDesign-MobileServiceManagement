package reportingservice;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import reportingservice.PropertyNameStrings.Events;

import static reportingservice.PropertyNameStrings.*;

/**
 * This is a concrete implementation of the Reporting Service. It is both an
 * observer and observable. It fulfills the automatic reports requirement.
 * <p>
 * The class listens for changes in the management classes, and will respond by
 * sending out commands to the management classes in order to have them print
 * out information.
 * <p>
 * This class adds/removes observers (PropertyChangeListeners) who listen for
 * its commands. For the midterm, these listeners would be the management
 * services.
 * <p>
 * In order to expand this class, PropertyChangeEvent propertyNames must meet
 * the required formatting:
 * <p>
 * propertyNames from Management classes should be in the format of:
 * <p>
 * "ManagementType::DetailType"
 * <p>
 * e.g. "Account::New" propertyNames
 *
 * @author Matthew Siu
 * @version December 31, 2020
 * @since December 30, 2020
 */

public class ConcreteReportingService implements PropertyChangeListener {

    private static final ConcreteReportingService uniqueInstance = new ConcreteReportingService();
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
     * <p>
     * It will respond by sending out the corresponding command to its listeners
     *
     * @param event an event from the management classes indicating the change
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        // property should be in format of "ManagementType::DetailType"
        // e.g. "Account::New"
        String property = event.getPropertyName();
        String managementType = property.substring(0, property.indexOf(PROPERTY_CHANGE_SCOPE_DELIMITER));
        String detailType = property.substring(
                property.indexOf(PROPERTY_CHANGE_SCOPE_DELIMITER) + PROPERTY_CHANGE_SCOPE_DELIMITER.length());
        
        if (managementType.equals(ACCOUNT)) {
            switch (detailType) {
                case NEW:
                    support.firePropertyChange(PRINT_ACCOUNT_ADDED, event.getOldValue(), event.getNewValue());
                    break;
                case UPDATING:
                case UPDATED:
                    support.firePropertyChange(PRINT_ACCOUNT_DETAILS, event.getOldValue(), event.getNewValue());
                    break;
                case DELETE:
                	// The below check is wild... apparently if we don't convert to string before comparing 'SPECIAL' != 'SPECIAL'
                    if (event.getOldValue().toString().equals(Events.SPECIAL.getDesc())) {
                        support.firePropertyChange(DELETE_USER, event.getOldValue(), event.getNewValue());
                    } else {
                        support.firePropertyChange(PRINT_ACCOUNT_DELETED, event.getOldValue(), event.getNewValue());
                    }
                    break;
                case DISPLAY:
                    if (event.getNewValue().equals(USER)) {
                        support.firePropertyChange(PRINT_USER_DETAILS, event.getOldValue(), event.getNewValue());
                    } else if (event.getNewValue().equals(BUNDLE)) {
                        support.firePropertyChange(PRINT_BUNDLE_DETAILS, event.getOldValue(), Events.SINGLE.getDesc());
                    } else if (event.getNewValue().equals(ACCOUNT)) {
                        support.firePropertyChange(PRINT_ACCOUNT_DETAILS, Events.SUCCESS.getDesc(), event.getOldValue());
                    } else {
                        support.firePropertyChange(PRINT_ACCOUNT_DETAILS, Events.FAILURE.getDesc(), event.getOldValue());
                    }
                case FIND:
                    if (event.getOldValue().equals(Events.SUCCESS.getDesc())) {
                        support.firePropertyChange(GET_ACCOUNT, event.getOldValue(), event.getNewValue());
                    } else if (event.getOldValue().equals(Events.SPECIAL.getDesc())) {
                        support.firePropertyChange(FIND_ACCOUNTS, event.getOldValue(), event.getNewValue());
                    }
                case LIST:
                    if (event.getOldValue().equals(Events.SUCCESS.getDesc())) {
                        support.firePropertyChange(GET_ACCOUNT_FEES, event.getOldValue(), event.getNewValue());
                    } else if (event.getOldValue().equals(Events.SPECIAL.getDesc())) {
                        support.firePropertyChange(FIND_ACCOUNTS_FEES, event.getOldValue(), event.getNewValue());
                    }
                default:
                    break;
            }
        } else if (managementType.equals(USER)) {
            switch (detailType) {
                case NEW:
                	support.firePropertyChange(PRINT_USER_ADDED, event.getOldValue(), event.getNewValue());
                	break;
                case UPDATING:
                	support.firePropertyChange(PRINT_USER_UPDATING, event.getOldValue(), event.getNewValue());
                	break;
                case UPDATED:
                	support.firePropertyChange(PRINT_USER_UPDATED, event.getOldValue(), event.getNewValue());
                	break;
                case DELETE:
                	support.firePropertyChange(PRINT_USER_DELETED, event.getOldValue(), event.getNewValue());
                	break;
                case DISPLAY:
                	if (event.getNewValue() == null) {
                        support.firePropertyChange(PRINT_USER_LIST, event.getOldValue(),  event.getNewValue());
                	}
                	else {
                        support.firePropertyChange(PRINT_USER_DETAILS, event.getOldValue(),  event.getNewValue());	
                	}
                    break;
                default:
                    break;
            }
        } else if (managementType.equals(BUNDLE)) {
            switch (detailType) {
	            case NEW:
	                support.firePropertyChange(PRINT_BUNDLE_ADDED, event.getOldValue(), event.getNewValue());
	                break;
	            case DISPLAY:
	                support.firePropertyChange(PRINT_BUNDLE_DETAILS, event.getOldValue(), event.getNewValue());
	            	break;
	            default:
	            	break;
            }
        }
    }
}
