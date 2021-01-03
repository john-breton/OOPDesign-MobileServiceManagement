package bundlemanagement.service;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BundleManagement {
	private static BundleManagement uniqueInstance = new BundleManagement();

	private BundleManagement() {
	}

	public static BundleManagement getBundleManagementInstance() {
		return uniqueInstance;
	}

	public Bundle addPreconfBundle(String name) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePreconfBundleFactory();
		bundle = factory.createBundle(name);
		return bundle;
	}

	public Bundle addPlainPacBundle(String name) {
		PaCBundle bundle;
		bundle = new BareBonePhoneService();
		bundle.setName(name);
		System.out.println("Your Plan:\n" + bundle.getDescription() + "total amount $" + bundle.cost() + "\n");
		return bundle;
	}

	public Bundle addPacBundleWithCallingOption(String name) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePacBundleWithCallingFactory();
		bundle = factory.createBundle(name);
		return bundle;
	}

	public Bundle addPacBundleWithMessagingOpiton(String name) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePacBundleWithMessagingFactory();
		bundle = factory.createBundle(name);
		return bundle;
	}

	public Bundle addPacBundleWithDataOpiton(String name) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePacBundleWithDataFactory();
		bundle = factory.createBundle(name);
		return bundle;
	}

}
