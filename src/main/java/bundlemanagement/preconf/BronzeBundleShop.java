package bundlemanagement.preconf;

public class BronzeBundleShop extends BundleShop {
	private static final String BRONZE_BUNDLE = "Bronze Bundle";
	private BundleComponentFactory bronzebundlecomponentfactory;

	public BronzeBundleShop() {
		this.bronzebundlecomponentfactory = new BronzeBundleComponentFactory();
	}

	protected Bundle createBundle() {
		Bundle bundle;
		bundle = new PreconfBundle(this.bronzebundlecomponentfactory);
		bundle.setName(BRONZE_BUNDLE);

		return bundle;

	}
}