package bundlemanagement.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * This is an abstract class for the Bundlemanagement class
 * @author esiumat
 *
 */
public abstract class AbstractBundleManagement implements PropertyChangeListener{

	/**
	 * Create a new Preconfigured Bundle based on the passing parameters.
	 * 
	 * @param bundleName Preconfigured Bundle Name options:PLATINUM, GOLD, SILVER,
	 *                   BRONZE
	 */
	public abstract void addPreconfBundle(String bundleName);
	
	/**
	 * Create a Plain Pick And Choose Bundle with only Bare Bone Phone Service
	 * 
	 * @param bundleName Bundle Name(unique identifier), only takes name PLAINPACBUNDLE
	 */
	public abstract void addPlainPacBundle(String bundleName);
	
	/**
	 * Create a PaC Bundle with only Calling option
	 * 
	 * @param bundleName Customer input Bundle Name (non case-sensitive), only
	 *                   accept: PaCWithPlatinumCalling, PaCWithGoldCalling,
	 *                   PaCWithSilverCalling, PaCWithBronzeCalling,
	 *                   PaCWithZeroCalling
	 */
	public abstract void addPacBundleWithCalling(String bundleName);
	
	/**
	 * Create a PaC Bundle with only Messaging option
	 * 
	 * @param name Customer input Bundle Name (non case-sensitive), only
	 *                   accept: PaCWithPlatinumMessaging, PaCWithGoldMessaging,
	 *                   PaCWithSilverMessaging, PaCWithBronzeMessaging,
	 *                   PaCWithZeroMessaging
	 */
	public abstract void addPacBundleWithMessaging(String name);

	/**
	 * Check to see if a bundle exists
	 *
	 * @return True if the bundle exists, false otherwise
	 */
	public abstract boolean bundleExists(String name);
	
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

	/**
	 * Removes listeners to this class.
	 *
	 * @param pcl a property change listener
	 */
	public abstract void removePropertyChangeListener(PropertyChangeListener pcl);
	
}
