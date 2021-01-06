package bundlemanagement.preconf;

import bundlemanagement.service.Bundle;

public class PlatinumBundleShop extends BundleShop {
	/**
	 * Create a variable type BundleComponentFactory. It will be later assigned at
	 * constructor.
	 */
	private BundleComponentFactory platinumbundlecomponentfactory;

	/**
	 * Constructor to set the BundleComponentFactory
	 */

	public PlatinumBundleShop() {
		this.platinumbundlecomponentfactory = new PlatinumBundleComponentFactory();
	}

	/**
	 * It will ask Bundle to create PreconfBundle type Platinum.
	 * 
	 * @return Bundle it will return Bundle(Platinum)
	 */
	protected PreconfBundle createBundle() {
		PreconfBundle bundle;

		bundle = new PreconfBundle(this.platinumbundlecomponentfactory);
		return bundle;

	}
}
