package bundlemanagement.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.concurrent.*;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

import static reportingservice.PropertyNameStrings.*;


/**
 * The BundleManagement class is responsible for managing bundles. There are two
 * types of service bundles: Preconfigured bundle and PaC(Plain and Choose)
 * bundle. A bundle is composed with bundle name(unique identifier), calling
 * plan, messaging plan, data plan and monthly fee.
 * <p>
 * The BundleManagement provides functionality such as add preconfigued bundle
 * and add PaC bundle. The newly created bundle will be added and maintained in
 * a bundle list.
 * <p>
 * BundleManagment is a Singleton to ensure that only one instance of the
 * BundleManagement class will exist at any given time.
 * 
 * @author Yangrui Zhu
 * @version 1.1
 * @since January 08, 2020
 */

public class BundleManagement extends AbstractBundleManagement {
	private volatile static BundleManagement UNIQUE_INSTANCE;
	private ConcurrentHashMap<BundleNames, Bundle> bundleList;
	private final PropertyChangeSupport support;

	/**
	 * Constructor for the BundleManagement class. Required to be private to ensure
	 * no more than one object can be created
	 */
	private BundleManagement() {
		bundleList = new ConcurrentHashMap<>();
		support = new PropertyChangeSupport(this);
	}

	/**
	 * Get the unique AccountManagement instance
	 * 
	 * @return The Singleton instance of the BundleManagement
	 */
	public static BundleManagement getInstance() {
		if (UNIQUE_INSTANCE == null) {
			synchronized (BundleManagement.class) {
				if (UNIQUE_INSTANCE == null) {
					UNIQUE_INSTANCE = new BundleManagement();
				}
			}
		}
		return UNIQUE_INSTANCE;
	}

	/**
	 * Create a new PaC Bundle based on the passing parameter. The name is required
	 * to be unique as it is the unique identifier of a bundle. Any option that is
	 * not needed can take a null as an input. A Bare Bone Phone Service will be add
	 * to the bundle automatically.
	 * 
	 * @param name            Bundle Name(unique identifier)
	 * @param CallingOption   Calling Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO,
	 *                        NONE.
	 * @param MessagingOption Messaging Options: PLATINUM, GOLD, SILVER, BRONZE,
	 *                        ZERO, NONE.
	 * @param DataOption      Data Options: PLATINUM, GOLD, SILVER, BRONZE, ZERO,
	 *                        NONE.
	 */
	private void addPaCBundle(BundleNames name, BundleOption CallingOption, BundleOption MessagingOption,
			BundleOption DataOption) {

		SimplePaCBundleFactory factory = new SimplePaCBundleFactory();
		PaCBundle pac = factory.createBundle(name, CallingOption, MessagingOption, DataOption);
		bundleList.put(name, pac);
		support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), name);
	}

	/**
	 * Create a new Preconfigured Bundle based on the passing parameters.
	 * 
	 * @param bundleName Preconfigured Bundle Name options:PLATINUM, GOLD, SILVER,
	 *                   BRONZE
	 */
	public void addPreconfBundle(String bundleName) {
		BundleNames name = convertBundleToEnum(bundleName);
		if (name == null) {
			return;
		}
		if (name != BundleNames.PLATINUM && name != BundleNames.GOLD && name != BundleNames.SILVER
				&& name != BundleNames.BRONZE) {
			System.out.println(
					"Sorry, we only take order for \"PLATINUM\", \"GOLD\", \"SILVER\", \"BRONZE\" Preconfigured Bundle in this option");
			return;
		}
		if (bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(),
					name);
			return;
		}

		SimplePreconfBundleFactory factory = new SimplePreconfBundleFactory();
		PreconfBundle preconf = factory.createBundle(name);
		if (preconf != null) {
			bundleList.put(name, preconf);
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(),
					name);
		} else {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(),
					name);
		}

	}

	/**
	 * Create a Plain Pick And Choose Bundle with only Bare Bone Phone Service
	 * 
	 * @param bundleName Bundle Name(unique identifier), only takes name PLAINPACBUNDLE
	 */
	public void addPlainPacBundle(String bundleName) {
		BundleNames name = convertBundleToEnum(bundleName);
		if (name != BundleNames.PLAIN_PAC_BUNDLE) {
			System.out.println("Sorry, we only take order for \"PLAINPACBUNDLE\" in this option");
			return;
		}
		if (bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(),
					name);
			return;
		}
		addPaCBundle(name, BundleOption.NONE, BundleOption.NONE, BundleOption.NONE);
	}

	/**
	 * Create a PaC Bundle with only Calling option
	 * 
	 * @param bundleName Customer input Bundle Name (non case-sensitive), only
	 *                   accept: PaCWithPlatinumCalling, PaCWithGoldCalling,
	 *                   PaCWithSilverCalling, PaCWithBronzeCalling,
	 *                   PaCWithZeroCalling
	 */
	public void addPacBundleWithCalling(String bundleName) {
		BundleNames name = convertBundleToEnum(bundleName);
		BundleOption level = checkPacCalling(name);
		if (level == null) {
			return;
		}

		if (bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), name);
			return;
		}

		addPaCBundle(name, level, BundleOption.NONE, BundleOption.NONE);
	}

	/**
	 * check if the bundle name is for pac bundle with calling plan
	 * 
	 * @param name bundle name in BundleNames Enum format.
	 * @return BundleOption return the calling plan level indicate by the bundle
	 *         name
	 */
	private BundleOption checkPacCalling(BundleNames name) {
		switch (name) {
		case PAC_WITH_GOLD_CALLING_PLAN:
			return BundleOption.GOLD;
		case PAC_WITH_PLATINUM_CALLING_PLAN:
			return BundleOption.PLATINUM;
		case PAC_WITH_BRONZE_CALLING_PLAN:
			return BundleOption.BRONZE;
		case PAC_WITH_SILVER_CALLING_PLAN:
			return BundleOption.SILVER;
		case PAC_WITH_ZERO_CALLING_PLAN:
			return BundleOption.ZERO;
		default:
			System.out.println("Sorry, we only take order for PaC Bundle with Calling Plan in this option");
			return null;
		}
	}

	/**
	 * Create a PaC Bundle with only Messaging option
	 * 
	 * @param bundleName Customer input Bundle Name (non case-sensitive), only
	 *                   accept: PaCWithPlatinumMessaging, PaCWithGoldMessaging,
	 *                   PaCWithSilverMessaging, PaCWithBronzeMessaging,
	 *                   PaCWithZeroMessaging
	 */
	public void addPacBundleWithMessaging(String bundleName) {
		BundleNames name = convertBundleToEnum(bundleName);
		BundleOption level = checkPacMessaging(name);
		if (level == null) {
			return;
		}
		if (bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), name);
			return;
		}

		addPaCBundle(name, BundleOption.NONE, level, BundleOption.NONE);
	}

	/**
	 * check if the bundle name is for pac bundle with messaging plan
	 * 
	 * @param name bundle name in BundleNames Enum format.
	 * @return BundleOption return the messaging plan level indicate by the bundle
	 *         name
	 */
	private BundleOption checkPacMessaging(BundleNames name) {
		switch (name) {
		case PAC_WITH_GOLD_MESSAGING_PLAN:
			return BundleOption.GOLD;
		case PAC_WITH_PLATINUM_MESSAGING_PLAN:
			return BundleOption.PLATINUM;
		case PAC_WITH_BRONZE_MESSAGING_PLAN:
			return BundleOption.BRONZE;
		case PAC_WITH_SILVER_MESSAGING_PLAN:
			return BundleOption.SILVER;
		case PAC_WITH_ZERO_MESSAGING_PLAN:
			return BundleOption.ZERO;
		default:
			System.out.println("Sorry, we only take order for PaC Bundle with Messaging Plan in this option");
			return null;
		}
	}

	/**
	 * convert string name to Enum
	 * 
	 * @param name bundle name in String formant.
	 * @return BundleNames return corresponding BundleNames Enum
	 */
	public BundleNames convertBundleToEnum(String name) {
		String bundleName = name.toUpperCase();
		switch (bundleName) {
		case "PLATINUM":
			return BundleNames.PLATINUM;
		case "GOLD":
			return BundleNames.GOLD;
		case "SILVER":
			return BundleNames.SILVER;
		case "BRONZE":
			return BundleNames.BRONZE;
		case "PLAINPACBUNDLE":
			return BundleNames.PLAIN_PAC_BUNDLE;
		case "PACWITHGOLDCALLING":
			return BundleNames.PAC_WITH_GOLD_CALLING_PLAN;
		case "PACWITHPLATINUMCALLING":
			return BundleNames.PAC_WITH_PLATINUM_CALLING_PLAN;
		case "PACWITHBRONZECALLING":
			return BundleNames.PAC_WITH_BRONZE_CALLING_PLAN;
		case "PACWITHSILVERCALLING":
			return BundleNames.PAC_WITH_SILVER_CALLING_PLAN;
		case "PACWITHZEROCALLING":
			return BundleNames.PAC_WITH_ZERO_CALLING_PLAN;
		case "PACWITHGOLDMESSAGING":
			return BundleNames.PAC_WITH_GOLD_MESSAGING_PLAN;
		case "PACWITHPLATINUMMESSAGING":
			return BundleNames.PAC_WITH_PLATINUM_MESSAGING_PLAN;
		case "PACWITHBRONZEMESSAGING":
			return BundleNames.PAC_WITH_BRONZE_MESSAGING_PLAN;
		case "PACWITHSILVERMESSAGING":
			return BundleNames.PAC_WITH_SILVER_MESSAGING_PLAN;
		case "PACWITHZEROMESSAGING":
			return BundleNames.PAC_WITH_ZERO_MESSAGING_PLAN;
		case "PACWITHGOLDDATA":
			return BundleNames.PAC_WITH_GOLD_DATA_PLAN;
		case "PACWITHPLATINUMDATA":
			return BundleNames.PAC_WITH_PLATINUM_DATA_PLAN;
		case "PACWITHSILVERDATA":
			return BundleNames.PAC_WITH_SILVER_DATA_PLAN;
		case "PACWITHBRONZEDATA":
			return BundleNames.PAC_WITH_BRONZE_DATA_PLAN;
		case "PACWITHZERODATA":
			return BundleNames.PAC_WITH_ZERO_DATA_PLAN;
		default:
			System.out.println("Invalid Bundle Name");
			return null;
		}
	}

	/**
     * Check to see if a bundle exists
     * 
     * @return True if the bundle exists, false otherwise
     */
    public boolean bundleExists(String name) {
        try {
        	return bundleList.containsKey(convertBundleToEnum(name));
        } catch (NullPointerException e) {
        	return false;
        }
    }

	/**
	 * Print out the details of a given bundle
	 * 
	 * @param bundle The bundle to be printed
	 */
	private void printBundleDetails(Bundle bundle) {
		System.out.println("\n---Bundle Detail---");
		System.out.printf("Bundle Name: %s\n", bundle.getName().getBundleNames());
		if (bundle instanceof PaCBundle) {
			System.out.print(((PaCBundle) bundle).getDescription());
			System.out.println("Monthly Fee: $" + bundle.cost());
		} else if (bundle instanceof PreconfBundle) {
			System.out.println(bundle);
		}

	}

	/**
	 * Print out the monthly fees of a given bundle
	 * 
	 * @param bundle The bundle to be printed
	 */
	private void printBundleFees(Bundle bundle) {
		System.out.println("\n---Monthly Fees---");
		System.out.printf("Bundle Name: %s\n", bundle.getName().getBundleNames());
		System.out.println("Monthly Fee: $" + bundle.cost());
	}

	/**
	 * Search the bundleList for bundle with the given bundle name and return the
	 * bundle if found
	 * 
	 * @param name Bundle Name
	 * @return The Bundle object that is associated with the bundle name provided
	 */
	private Bundle getBundle(BundleNames name) {
		if (bundleList.containsKey(name)) {
			return bundleList.get(name);
		}
		return null;
	}

	/**
	 * List all Preconfigured Bundles Names
	 */
	public void listAllPreconfBundles() {
		System.out.println("\n---Preconfigured Bundles---");
		for (Map.Entry bundle : bundleList.entrySet()) {
			if (bundle.getValue() instanceof PreconfBundle) {
				System.out.println(((BundleNames) bundle.getKey()).getBundleNames());
			}
		}
	}

	/**
	 * List all PaC Bundles Names
	 */
	public void listAllPacBundles() {
		System.out.println("\n---PaC Bundles---");
		for (Map.Entry bundle : bundleList.entrySet()) {
			if (bundle.getValue() instanceof PaCBundle) {
				System.out.println(((BundleNames) bundle.getKey()).getBundleNames());
			}
		}
	}

	/**
	 * Handle the various event from ReportingService. Any unknown events are
	 * ignored.
	 * 
	 * @param evt an event from ReportingService indicating the change
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
		case PRINT_BUNDLE_ADDED:
			BundleNames bundleName = (BundleNames) evt.getNewValue();
			if (evt.getOldValue().equals(Events.FAILURE.getDesc())) {
				System.out.printf("\nCould not create the requested bundle option: %s \n", bundleName.getBundleNames());
			} else if (evt.getOldValue().equals(Events.SUCCESS.getDesc())) {
				try {
					System.out.print("New Bundle Added:");
					printBundleDetails(Objects.requireNonNull(getBundle(bundleName)));
				} catch (NullPointerException e) {
					System.out.println("Invalid bundle, could not be printed.");
				}

			}
			break;
		case PRINT_BUNDLE_DETAILS:
			if (evt.getNewValue().equals(Events.SINGLE.getDesc())) {// print single bundle detail
				String name = (String) evt.getOldValue();
				Bundle bundle = getBundle(convertBundleToEnum(name));
				if (bundle != null) {
					printBundleDetails(bundle);
				} else {
					System.out.printf("No Bundle with the name \"%s\" was found.\n", evt.getOldValue());
				}
			} else if (evt.getNewValue().equals(Events.PAC.getDesc())) {// list all pac bundles names
				listAllPacBundles();
			} else if (evt.getNewValue().equals(Events.PRECFG.getDesc())) {// list all preconfigured bundles
																						// names
				listAllPreconfBundles();
			} else if (evt.getNewValue().equals(Events.FEES.getDesc())) {// display single bundle's monthly
																					// fees
				Bundle bundle = getBundle(convertBundleToEnum((String) evt.getOldValue()));
				if (bundle != null) {
					printBundleFees(bundle);
				} else {
					System.out.printf("No Bundle with the name \"%s\" was found.\n", evt.getOldValue());
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
