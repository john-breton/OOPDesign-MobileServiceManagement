package bundlemanagement.preconf;

public class GoldBundleShop extends BundleShop {
	private static final String GOLD_BUNDLE = "Gold Bundle";
	private BundleComponentFactory goldbundlecomponentfactory;

	public GoldBundleShop() {
		this.goldbundlecomponentfactory = new GoldBundleComponentFactory();
	}

	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.goldbundlecomponentfactory);
		bundle.setName(GOLD_BUNDLE);

		return bundle;

	}
}
