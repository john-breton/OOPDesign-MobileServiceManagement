package bundlemanagement.service;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import static reportingservice.PropertyNameStrings.*;

public class BundleManagement implements PropertyChangeListener{
	private static final BundleManagement uniqueInstance = new BundleManagement();
	private final HashMap<String, Bundle> bundleList;

	
	private final PropertyChangeSupport support;

	private BundleManagement() {
		bundleList = new HashMap<>();
		support = new PropertyChangeSupport(this);
	}

	public static BundleManagement getInstance() {
		return uniqueInstance;
	}

	public void addPaCBundle(String name, BundleOption CallingOption, BundleOption MessagingOption, BundleOption DataOption) {
		if(bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), name);
			return;			
		}

		SimplePaCBundleFactory factory = new SimplePaCBundleFactory();
		PaCBundle pac = factory.createBundle(name, CallingOption, MessagingOption, DataOption);
		bundleList.put(name, pac);
		support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), name);			
	}
	
	public void addPreconfBundle(String name, BundleOption option) {
		if(bundleList.containsKey(name)) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.FAILURE.getDesc(), name);
			return;			
		}
		
		SimplePreconfBundleFactory factory = new SimplePreconfBundleFactory();
		PreconfBundle preconf = factory.createBundle(name, option);
		bundleList.put(name, preconf);
		support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + NEW, Events.SUCCESS.getDesc(), preconf.getName());
		
	}
	
	public void addPlainPacBundle(String name) {
		addPaCBundle(name, null, null, null);
	}
	
	public void addPacBundleWithCalling(String name, BundleOption callingOption) {
		addPaCBundle(name, callingOption, null, null);
	}
	
	public void addPacBundleWithMessaging(String name, BundleOption messagingOption) {
		addPaCBundle(name, null, messagingOption, null);
	}
	private void printBundleDetails(Bundle bundle) {
		System.out.println("\n---Bundle Detail---");
		System.out.printf("Name: %s\n", bundle.getName());
		if(bundle instanceof PaCBundle) {
			System.out.print(((PaCBundle)bundle).getDescription());
			System.out.println("Monthly Fee: $" + ((PaCBundle)bundle).cost());
		}else if(bundle instanceof PreconfBundle) {
			System.out.println((PreconfBundle)bundle);
		}
		
	}
	private Bundle getBundle(String name) {
		if(bundleList.containsKey(name)) {
			return bundleList.get(name);
		}
		return null;
	}
	
	/*
	 * Test print single bundle detail function
	private void listBundleDetail(String name) {
		support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, name, Events.SINGLE.getDesc());
	}*/
	
	private void listAllPreconfBundles() {
		System.out.println("\n---Preconfigured Bundles---");
		for(Map.Entry bundle: bundleList.entrySet()) {
			if(bundle.getValue() instanceof PreconfBundle) {
				System.out.println(bundle.getKey());
			}
		}		
	}
	private void listAllPacBundles() {
		System.out.println("\n---PaC Bundles---");
		for(Map.Entry bundle: bundleList.entrySet()) {
			if(bundle.getValue() instanceof PaCBundle) {
				System.out.println(bundle.getKey());
			}
		}
	}

	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch(evt.getPropertyName()) {
		case PRINT_BUNDLE_ADDED:
			if(evt.getOldValue().equals(Events.FAILURE.getDesc())) {
				System.out.printf("\nFailed to add a new bundle. The bundle name \"%s\" is already used by another bundle.\n", evt.getNewValue());
			}else if(evt.getOldValue().equals(Events.SUCCESS.getDesc())){
				printBundleDetails(Objects.requireNonNull(getBundle((String)evt.getNewValue())));
				
			}
			break;
		case PRINT_BUNDLE_DETAILS:
			if(((String)evt.getNewValue()).equals(Events.SINGLE.getDesc())) {//print single bundle detail
				Bundle bundle = getBundle((String)evt.getOldValue());
				if(bundle != null) {
					printBundleDetails(bundle);
				}else {
					System.out.printf("No Bundle with the name \"%s\" was found.\n",(String)evt.getOldValue());
				}	
			}else if(((String)evt.getNewValue()).equals(Events.PAC.getDesc())){//list all pac bundles names
				listAllPacBundles();
			}else if(((String)evt.getNewValue()).equals(Events.PRECFG.getDesc())) {//list all preconfigured bundles names
				listAllPreconfBundles();
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
