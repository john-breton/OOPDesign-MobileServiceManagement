package bundlemanagement.preconf;

public class PlatinumBundleShop extends BundleShop {

	/**
	 * @param PLATINUM_BUNDLE The name for platinum bundle.
	 */
	private static final String PLATINUM_BUNDLE = "Platinum Bundle";

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
	protected Bundle createBundle() {
		Bundle bundle;

		bundle = new PreconfBundle(this.platinumbundlecomponentfactory);
		bundle.setName(PLATINUM_BUNDLE);

		return bundle;

	}
}
