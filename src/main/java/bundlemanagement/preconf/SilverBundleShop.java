package bundlemanagement.preconf;

public class SilverBundleShop extends BundleShop {
	private static final String SILVER_BUNDLE = "Silver Bundle";
	private BundleComponentFactory silverbundlecomponentfactory;

	public SilverBundleShop() {
		this.silverbundlecomponentfactory = new SilverBundleComponentFactory();
	}

	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.silverbundlecomponentfactory);
		bundle.setName(SILVER_BUNDLE);

		return bundle;

	}
}
