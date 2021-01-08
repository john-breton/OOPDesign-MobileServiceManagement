package bundlemanagement.preconf;

/**
 * This class will receive order to create gold preconf Bundle. It will then ask
 * Preconf Bundle to create all needed component for preconf gold bundle plan.
 * 
 * @author epahram
 *
 */

public class GoldBundleShop extends BundleShop {
	private BundleComponentFactory goldbundlecomponentfactory;

	/**
	 * constructor set up BundleComponentFactory to GoldBundleComponentFactory.
	 */
	public GoldBundleShop() {
		this.goldbundlecomponentfactory = new GoldBundleComponentFactory();
	}

	/**
	 * This method asks preconfBundle class to create related calling plan,
	 * messaging plan,data plan, and monthly fee for gold preconf plan.
	 * 
	 * @return Bundle
	 */
	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.goldbundlecomponentfactory);

		return bundle;

	}
}
