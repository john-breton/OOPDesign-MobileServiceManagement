package userinterface;

import static reportingservice.PropertyNameStrings.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class is simply responsible for firing PropertyChangeEvents to
 * ReportingService such that it will send events to the relevant
 * management classes for printing the necessary report information.
 * 
 * @author eleugab
 */
public class UserInterfaceManagement {
    private static UserInterfaceManagement uniqueInstance = new UserInterfaceManagement();
    private PropertyChangeSupport support;
    
    /**
     * Constructor for UserInterfaceManagement
     */
    private UserInterfaceManagement() {
        support = new PropertyChangeSupport(this);
    }
    
    /**
     * getInstance method to make this class a singleton
     */
    public static UserInterfaceManagement getInstance() {
        return uniqueInstance;
    }

    /**
     * This method fires off a PropertyChangeEvent to print all user names
     * currently in the system
     */
    public void listAllUserNames() {
        support.firePropertyChange(USER + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, Events.SUCCESS.getDesc(), null);
    }

    /**
     * This method fires off a PropertyChangeEvent to print the account
     * information for an existing account
     * 
     * @param phoneNum the phone number associated with the account
     */
    public void listAccount(String phoneNum) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + FIND, Events.SUCCESS.getDesc(), phoneNum);
    }

    /**
     * This method fires off a PropertyChangeEvent to print the account
     * information for all accounts associated with a given user name
     * 
     * @param username the user name associated with the accounts
     */
    public void listAccounts(String username) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + FIND, Events.SPECIAL.getDesc(), username);
    }

    /**
     * This method fires off a PropertyChangeEvent to print the monthly fees
     * for an existing account
     * 
     * @param phoneNum the phone number associated with the account
     */
    public void listMonthlyFeesByPhone(String phoneNum) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + LIST, Events.SUCCESS.getDesc(), phoneNum);
    }

    /**
     * This method fires off a PropertyChangeEvent to print the monthly fees
     * for all accounts associated with a given user name
     * 
     * @param username the user name associated with the accounts
     */
    public void listMonthlyFeesByUser(String username) {
        support.firePropertyChange(ACCOUNT + PROPERTY_CHANGE_SCOPE_DELIMITER + LIST, Events.SPECIAL.getDesc(), username);
    }

    /**
     * This method fires off a PropertyChangeEvent to print the bundle
     * information given the bundle name
     * 
     * @param name the bundle name
     */
    public void printBundleDetails(String name) {
        support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, name, Events.SINGLE.getDesc());
    }

    /**
     * This method fires off a PropertyChangeEvent to print all
     * the Pac bundle names that currently exist on the system
     */
    public void listAllPacBundles() {
        support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, null, Events.PAC.getDesc());
    }

    /**
     * This method fires off a PropertyChangeEvent to print all
     * the preconfigured bundle names that currently exist on the system
     */
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