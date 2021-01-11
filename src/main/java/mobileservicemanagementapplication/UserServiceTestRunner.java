package mobileservicemanagementapplication;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import reportingservice.PropertyNameStrings;

/**
 * @author edavleu
 *
 */
public class UserServiceTestRunner {

	private PropertyChangeSupport support;
	
	public UserServiceTestRunner() {
		support = new PropertyChangeSupport(this);
	}
	
	public void printUser(String userId) {
		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DISPLAY,
				PropertyNameStrings.Events.SUCCESS,
				userId);
	}
	
	public void printAllUserNames() {
		support.firePropertyChange(
				PropertyNameStrings.USER + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DISPLAY,
				PropertyNameStrings.Events.SUCCESS,
				null);
	}
	
	public void deleteUser(String userId) {
		support.firePropertyChange(
				PropertyNameStrings.ACCOUNT + PropertyNameStrings.PROPERTY_CHANGE_SCOPE_DELIMITER + PropertyNameStrings.DELETE,
				PropertyNameStrings.Events.SPECIAL,
				userId);
	}

	/**
	 * Adds listeners to this class.
	 * 
	 * @param pcl a property change listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		System.out.println("[MAIN] Added property change listener");
		support.addPropertyChangeListener(pcl);
	}
}
