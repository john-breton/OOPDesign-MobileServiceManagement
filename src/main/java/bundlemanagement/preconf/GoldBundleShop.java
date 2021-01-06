package bundlemanagement.preconf;

public class GoldBundleShop extends BundleShop {
	private BundleComponentFactory goldbundlecomponentfactory;

	public GoldBundleShop() {
		this.goldbundlecomponentfactory = new GoldBundleComponentFactory();
	}

	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.goldbundlecomponentfactory);

		return bundle;

	}
}
