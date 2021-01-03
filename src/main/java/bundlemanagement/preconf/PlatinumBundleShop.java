package bundlemanagement.preconf;

public class PlatinumBundleShop extends BundleShop {
	private static final String PLATINUM_BUNDLE = "Platinum Bundle";
	private BundleComponentFactory platinumbundlecomponentfactory;

	public PlatinumBundleShop() {
		this.platinumbundlecomponentfactory = new PlatinumBundleComponentFactory();
	}

	protected PreconfBundle createBundle() {
		PreconfBundle bundle;

		bundle = new PreconfBundle(this.platinumbundlecomponentfactory);
		bundle.setName(PLATINUM_BUNDLE);

		return bundle;

	}
}
