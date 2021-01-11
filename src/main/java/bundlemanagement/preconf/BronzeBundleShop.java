package bundlemanagement.preconf;

/**
 * This class will receive order to create bronze preconf Bundle. It will then
 * ask Preconf Bundle to create all needed component for preconf
 * bronze bundle plan.
 * 
 * @author epahram
 *
 */

public class BronzeBundleShop extends BundleShop {
	private BundleComponentFactory bronzebundlecomponentfactory;

	/**
	 * constructor set up BundleComponentFactory to BronzeBundleComponentFactory.
	 */
	public BronzeBundleShop() {
		this.bronzebundlecomponentfactory = new BronzeBundleComponentFactory();
	}

	/**
	 * This method asks preconfBundle class to create related calling plan,
	 * messaging plan,data plan, and monthly fee for bronze preconf plan.
	 * 
	 * @return Bundle
	 */
	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.bronzebundlecomponentfactory);

		return bundle;

	}
}
