package bundlemanagement.service;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BundleManagement {
	private static final BundleManagement uniqueInstance = new BundleManagement();

	private BundleManagement() {
	}

	public static BundleManagement getBundleManagementInstance() {
		return uniqueInstance;
	}

	public Bundle addPreconfBundle(BundleOption option) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePreconfBundleFactory();
		bundle = factory.createBundle(option);
		return bundle;
	}

	public Bundle addPlainPacBundle(BundleOption option) {
		PaCBundle bundle;
		bundle = new BareBonePhoneService();
		bundle.setName("Plain PaC Bundle");
		System.out.println("Your Plan:\n" + bundle.getDescription() + "total amount $" + bundle.cost() + "\n");
		return bundle;
	}

	public Bundle addPacBundleWithCallingOption(BundleOption option) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePacBundleWithCallingFactory();
		bundle = factory.createBundle(option);
		return bundle;
	}

	public Bundle addPacBundleWithMessagingOpiton(BundleOption option) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePacBundleWithMessagingFactory();
		bundle = factory.createBundle(option);
		return bundle;
	}

	public Bundle addPacBundleWithDataOpiton(BundleOption option) {
		Bundle bundle;
		SimpleBundleFactory factory = new SimplePacBundleWithDataFactory();
		bundle = factory.createBundle(option);
		return bundle;
	}

}
