package bundlemanagement.preconf;

/**
 * This class will receive order to create platinum preconf Bundle. It will then
 * ask Preconf Bundle to create all needed component for preconf platinum bundle
 * plan.
 * 
 * @author epahram
 *
 */

public class PlatinumBundleShop extends BundleShop {

	private BundleComponentFactory platinumbundlecomponentfactory;

	/**
	 * constructor set up BundleComponentFactory to PlatinumBundleComponentFactory.
	 */

	public PlatinumBundleShop() {
		this.platinumbundlecomponentfactory = new PlatinumBundleComponentFactory();
	}

	/**
	 * This method asks preconfBundle class to create related calling plan,
	 * messaging plan,data plan, and monthly fee for platinum preconf plan.
	 * 
	 * @return Bundle
	 */
	protected PreconfBundle createBundle() {
		PreconfBundle bundle;

		bundle = new PreconfBundle(this.platinumbundlecomponentfactory);
		return bundle;

	}
}
