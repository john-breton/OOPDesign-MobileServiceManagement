package bundlemanagement.preconf;

/**
 * This class will receive order to create platinum preconf Bundle. It will then
 * ask Preconf Bundle to create all needed component for preconf silver bundle
 * plan.
 * 
 * @author epahram
 *
 */

public class SilverBundleShop extends BundleShop {
	private BundleComponentFactory silverbundlecomponentfactory;

	/**
	 * constructor set up BundleComponentFactory to SilverBundleComponentFactory.
	 */
	public SilverBundleShop() {
		this.silverbundlecomponentfactory = new SilverBundleComponentFactory();
	}

	/**
	 * This method asks preconfBundle class to create related calling plan,
	 * messaging plan,data plan, and monthly fee for silver preconf plan.
	 * 
	 * @return Bundle
	 */
	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.silverbundlecomponentfactory);

		return bundle;

	}
}
