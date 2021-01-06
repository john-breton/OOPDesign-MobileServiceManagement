/**
 * 
 */
package mobileservicemanagementapplication;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.TreeMap;
import reportingservice.PropertyNameStrings;

/**
 * @author edavleu
 *
 */
public class MobileServiceManagementClass {

	private PropertyChangeSupport support;
	
	public MobileServiceManagementClass() {
		support = new PropertyChangeSupport(this);
	}
	
	public void addUser() {
		TreeMap<String,Object> newValue = new TreeMap<String,Object>();
		newValue.put("userId", "Chen");
		newValue.put("address", "123 Main st.");
		support.firePropertyChange(PropertyNameStrings.ADD_USER, new TreeMap<String,Object>(), newValue);
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
