package bundlemanagement.service;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import static reportingservice.PropertyNameStrings.*;
/**
 * The BundleManagement class is responsible for managing bundles. There are 
 * two types of service bundles: Preconfigured bundle and PaC(Plain and Choose) bundle.
 * A bundle is composed with bundle name(unique identifier), calling plan, messaging plan, 
 * data plan and monthly fee.
 * <p>
 * The BundleManagement provides functionality such as add preconfigued bundle and 
 * add PaC bundle. The newly created bundle will be added and maintained in a bundle list.
 * <p>
 * BundleManagment is a Singleton to ensure that only one instance of the BundleManagement
 * class will exist at any given time.
 * @author Yangrui Zhu
 * @version 1.0
 * @since January 08, 2020
 */

public class BundleManagement implements PropertyChangeListener {
	private static final BundleManagement UNIQUE_INSTANCE = new BundleManagement();
	private final HashMap<String, Bundle> bundleList;

	private final PropertyChangeSupport support;

	/**
	 * Constructor for the BundleManagement class.
	 * Required to be private to ensure no more than one
	 * object can be created
	 */	
	private BundleManagement() {
		bundleList = new HashMap<>();
		support = new PropertyChangeSupport(this);
	}

	/**
	 * Get the unique AccountManagement instance
	 * @return The Singleton instance of the BundleManagement
	 */
	public static BundleManagement getInstance() {
		return UNIQUE_INSTANCE;
	}

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
	public void addPaCBundle(String name, BundleOption CallingOption, BundleOption MessagingOption,
			BundleOption DataOption) {
		if (bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), name);
			return;
		}

		SimplePaCBundleFactory factory = new SimplePaCBundleFactory();
		PaCBundle pac = factory.createBundle(name, CallingOption, MessagingOption, DataOption);
		bundleList.put(name, pac);
		support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), name);
	}

	/**
	 * Create a new Preconfigured Bundle based on the passing parameters. The name is required
	 * to be unique as it is the unique identifier of a bundle.
	 * @param name     Bundle Name(unique identifier)
	 * @param option   Preconfigured Bundle options:PLATINUM, GOLD, SILVER, BRONZE
	 */
	public void addPreconfBundle(String name, BundleOption option) {
		if (bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), name);
			return;
		}

		SimplePreconfBundleFactory factory = new SimplePreconfBundleFactory();
		PreconfBundle preconf = factory.createBundle(name, option);
		if(preconf != null) {
		    bundleList.put(name, preconf);
	        support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(),
	                preconf.getName());
		} else {
		    System.out.println("Could not create the requested bundle option.");
		    System.out.printf("%s is not a valid pre-configured bundle!\n", name);
		    support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), name);
		    return;
		}
		

	}

	/**
	 * Create a Plain Pick And Choose Bundle with only Bare Bone Phone Service
	 * @param name  Bundle Name(unique identifier)
	 */
	public void addPlainPacBundle(String name) {
		addPaCBundle(name, null, null, null);
	}

	/**
	 * Create a PaC Bundle with only Calling option
	 * @param name            Bundle Name(unique identifier)
	 * @param callingOption   Calling Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 */
	public void addPacBundleWithCalling(String name, BundleOption callingOption) {
		addPaCBundle(name, callingOption, null, null);
	}

	/**
	 * Create a PaC Bundle with only Messaging option
	 * @param name             Bundle Name(unique identifier)
	 * @param messagingOption  Messaging Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO. Put null if not needed
	 */
	public void addPacBundleWithMessaging(String name, BundleOption messagingOption) {
		addPaCBundle(name, null, messagingOption, null);
	}

	/**
	 * Print out the details of a given bundle
	 * @param bundle  The bundle to be printed
	 */
	private void printBundleDetails(Bundle bundle) {
		System.out.println("\n---Bundle Detail---");
		System.out.printf("Bundle Name: %s\n", bundle.getName());
		if (bundle instanceof PaCBundle) {
			System.out.print(((PaCBundle) bundle).getDescription());
			System.out.println("Monthly Fee: $" + ((PaCBundle) bundle).cost());
		} else if (bundle instanceof PreconfBundle) {
			System.out.println((PreconfBundle) bundle);
		}

	}
	/**
	 * Print out the monthly fees of a given bundle
	 * @param bundle  The bundle to be printed
	 */		
	private void printBundleFees(Bundle bundle) {
		System.out.println("\n---Monthly Fees---");
		System.out.printf("Bundle Name: %s\n", bundle.getName());
		if (bundle instanceof PaCBundle) {
			System.out.println("Monthly Fee: $" + ((PaCBundle) bundle).cost());
		} else if (bundle instanceof PreconfBundle) {
			System.out.println("Monthly Fee: $" + ((PreconfBundle) bundle). getMonthlyFees());
		}		
	}

	/**
	 * Search the bundleList for bundle with the given bundle name and return 
	 * the bundle if found
	 * @param name Bundle Name
	 * @return     The Bundle object that is associated with the bundle name provided
	 */
	private Bundle getBundle(String name) {
		if (bundleList.containsKey(name)) {
			return bundleList.get(name);
		}
		return null;
	}

	/**
	 * List all Preconfigured Bundles Names
	 */
	private void listAllPreconfBundles() {
		System.out.println("\n---Preconfigured Bundles---");
		for (Map.Entry bundle : bundleList.entrySet()) {
			if (bundle.getValue() instanceof PreconfBundle) {
				System.out.println(bundle.getKey());
			}
		}
	}

	/**
	 * List all PaC Bundles Names
	 */
	private void listAllPacBundles() {
		System.out.println("\n---PaC Bundles---");
		for (Map.Entry bundle : bundleList.entrySet()) {
			if (bundle.getValue() instanceof PaCBundle) {
				System.out.println(bundle.getKey());
			}
		}
	}

	/**
	 *Handle the various event from ConcreteReportingService. Any unknown
     * events are ignored.
     * @param evt an event from ConcreteReportingService indicating the change
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
		case PRINT_BUNDLE_ADDED:
			if (evt.getOldValue().equals(Events.FAILURE.getDesc())) {
				System.out.printf(
						"\nFailed to add a new bundle. The bundle name \"%s\" is already used by another bundle.\n",
						evt.getNewValue());
			} else if (evt.getOldValue().equals(Events.SUCCESS.getDesc())) {
				printBundleDetails(Objects.requireNonNull(getBundle((String) evt.getNewValue())));

			}
			break;
		case PRINT_BUNDLE_DETAILS:
			if (((String) evt.getNewValue()).equals(Events.SINGLE.getDesc())) {// print single bundle detail
				Bundle bundle = getBundle((String) evt.getOldValue());
				if (bundle != null) {
					printBundleDetails(bundle);
				} else {
					System.out.printf("No Bundle with the name \"%s\" was found.\n", (String) evt.getOldValue());
				}
			} else if (((String) evt.getNewValue()).equals(Events.PAC.getDesc())) {// list all pac bundles names
				listAllPacBundles();
			} else if (((String) evt.getNewValue()).equals(Events.PRECFG.getDesc())) {// list all preconfigured bundles																					// names
				listAllPreconfBundles();
			} else if(((String) evt.getNewValue()).equals(Events.FEES.getDesc())) {//display single bundle's monthly fees
				Bundle bundle = getBundle((String) evt.getOldValue());
				if (bundle != null) {
					printBundleFees(bundle);
				} else {
					System.out.printf("No Bundle with the name \"%s\" was found.\n", (String) evt.getOldValue());
				}				
			}

			break;

		}
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
