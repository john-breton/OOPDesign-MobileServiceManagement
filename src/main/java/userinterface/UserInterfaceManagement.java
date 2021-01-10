package userinterface;

import static reportingservice.PropertyNameStrings.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import reportingservice.PropertyNameStrings.Events;

/**
 * 
 * @author eleugab
 *
 */
public class UserInterfaceManagement {
    private static UserInterfaceManagement uniqueInstance = new UserInterfaceManagement();
    private PropertyChangeSupport support;
    
    private UserInterfaceManagement() {
        support = new PropertyChangeSupport(this);
    }
    
    public static UserInterfaceManagement getInstance() {
        return uniqueInstance;
    }

    public void listAllUserNames() {
        support.firePropertyChange(USER + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, Events.SUCCESS.getDesc(), null);
    }

    public void listAccount(String phoneNum) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + FIND, Events.SUCCESS.getDesc(), phoneNum);
    }

    public void listAccounts(String username) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + FIND, Events.SPECIAL.getDesc(), username);
    }

    public void listMonthlyFeesByPhone(String phoneNum) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + LIST, Events.SUCCESS.getDesc(), phoneNum);
    }

    public void listMonthlyFeesByUser(String username) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + LIST, Events.SPECIAL.getDesc(), username);
    }

    public void printBundleDetails(String name) {
        support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, name, Events.SINGLE.getDesc());
    }
    
    public void listAllPacBundles() {
        support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, null, Events.PAC.getDesc());
    }
    
    public void listAllPreconfBundles() {
        support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, null, Events.PRECFG.getDesc());
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
}