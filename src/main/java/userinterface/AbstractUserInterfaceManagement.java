package userinterface;

import java.beans.PropertyChangeListener;

/**
 * This class is simply responsible for firing PropertyChangeEvents to
 * ReportingService such that it will send events to the relevant
 * management classes for printing the necessary report information.
 * 
 * @author eleugab
 */
public abstract class AbstractUserInterfaceManagement {

    /**
     * This method fires off a PropertyChangeEvent to print all user names
     * currently in the system
     */
    public abstract void listAllUserNames();

    /**
     * This method fires off a PropertyChangeEvent to print the account
     * information for an existing account
     * 
     * @param phoneNum the phone number associated with the account
     */
    public abstract void listAccount(String phoneNum);

    /**
     * This method fires off a PropertyChangeEvent to print the account
     * information for all accounts associated with a given user name
     * 
     * @param username the user name associated with the accounts
     */
	public abstract void listAccounts(String username);

    /**
     * This method fires off a PropertyChangeEvent to print the monthly fees
     * for an existing account
     * 
     * @param phoneNum the phone number associated with the account
     */
    public abstract void listMonthlyFeesByPhone(String phoneNum);

    /**
     * This method fires off a PropertyChangeEvent to print the monthly fees
     * for all accounts associated with a given user name
     * 
     * @param username the user name associated with the accounts
     */
    public abstract void listMonthlyFeesByUser(String username);

    /**
     * This method fires off a PropertyChangeEvent to print the bundle
     * information given the bundle name
     * 
     * @param name the bundle name
     */
    public abstract void printBundleDetails(String name);

    /**
     * This method fires off a PropertyChangeEvent to print all
     * the Pac bundle names that currently exist on the system
     */
    public abstract void listAllPacBundles();

    /**
     * This method fires off a PropertyChangeEvent to print all
     * the preconfigured bundle names that currently exist on the system
     */
    public abstract void listAllPreconfBundles();
    
    /**
     * Adds listeners to this class.
     * 
     * @param pcl a property change listener
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener pcl);
    
    /**
     * Removes listeners to this class.
     *
     * @param pcl a property change listener
     */
    public abstract void removePropertyChangeListener(PropertyChangeListener pcl);
}