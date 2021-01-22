package bundlemanagement.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * This is an abstract class for the Bundlemanagement class
 * @author esiumat
 *
 */
public abstract class BundleManagement_Abstract implements PropertyChangeListener{

	/**
	 * Create a new PaC Bundle based on the passing parameter. The name is required
	 * to be unique as it is the unique identifier of a bundle. Any option that is not needed
	 * can take a null as an input. A Bare Bone Phone Service will be add to the bundle automatically.
	 * 
	 * @param name             Bundle Name(unique identifier)
	 * @param CallingOption    Calling Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 * @param MessagingOption  Messaging Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 * @param DataOption       Data Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 */
	public abstract void addPaCBundle(String name, BundleOption CallingOption, BundleOption MessagingOption,
			BundleOption DataOption);
	/**
	 * Create a new Preconfigured Bundle based on the passing parameters. The name is required
	 * to be unique as it is the unique identifier of a bundle.
	 * @param name     Bundle Name(unique identifier)
	 * @param option   Preconfigured Bundle options:PLATINUM, GOLD, SILVER, BRONZE
	 */
	public abstract void addPreconfBundle(String name, BundleOption option);
	
	/**
	 * Create a Plain Pick And Choose Bundle with only Bare Bone Phone Service
	 * @param name  Bundle Name(unique identifier)
	 */
	public abstract void addPlainPacBundle(String name);
	
	/**
	 * Create a PaC Bundle with only Calling option
	 * @param name            Bundle Name(unique identifier)
	 * @param callingOption   Calling Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 */
	public abstract void addPacBundleWithCalling(String name, BundleOption callingOption);
	
	/**
	 * Create a PaC Bundle with only Messaging option
	 * @param name             Bundle Name(unique identifier)
	 * @param messagingOption  Messaging Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 */
	public abstract void addPacBundleWithMessaging(String name, BundleOption messagingOption);
	
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
