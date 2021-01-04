package reportingservice;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import static reportingservice.PropertyNameStrings.*;


/**
 * This is a template for the management classes. It is both an observer and
 * observable.
 * 
 * The class listens for commands from the ConcreteReportingService, and will
 * respond by printing out the required information
 * 
 * This class adds/removes observers (PropertyChangeListeners) who listen for
 * its commands. For the midterm, the only listener would be the
 * ConcreteReportingService.
 * 
 * In order to use this template, PropertyChangeEvent propertyNames fired from
 * this class must meet the required formatting:
 * 
 * "ManagementType::DetailType"
 * 
 * e.g. "Account::New" propertyNames
 * 
 * @author Matthew Siu
 * @version December 31, 2020
 * @since December 30, 2020
 *
 */

public class ManagementReportingServiceTemplate implements PropertyChangeListener {
	private static ManagementReportingServiceTemplate uniqueInstance = new ManagementReportingServiceTemplate();
	private PropertyChangeSupport support;

	/**
	 * Constructor for ConcreteReportingService.
	 * 
	 */
	private ManagementReportingServiceTemplate() {
		// add this to your constructor
		support = new PropertyChangeSupport(this);
	}
	
	/**
	 * getInstance method to ensure it is a singleton
	 */
	public static ManagementReportingServiceTemplate getInstance() {
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
	 * This method is called whenever a command is sent out from the
	 * concreteReportingService
	 * 
	 * It will respond by sending out the corresponding command to its listeners
	 * 
	 * @param event a command from the ConcreteReportingService
	 */
	public void propertyChange(PropertyChangeEvent event) {
		// example
		if (event.getPropertyName().equals(PRINT_ACCOUNT_DETAILS)) {
			// print out required details
			System.out.println("Here's some important information!");
		}
		// otherwise ignore this. Other management classes will print out other required
		// information
	}
	
	/**
	 * Arbitrary test method
	 */
	public void createAccount() {
		System.out.println("creating new account");
		support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, "old information", "new information");
	}
}
