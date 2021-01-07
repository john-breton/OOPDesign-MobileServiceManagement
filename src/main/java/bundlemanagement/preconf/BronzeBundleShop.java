package bundlemanagement.preconf;

public class BronzeBundleShop extends BundleShop {
	private BundleComponentFactory bronzebundlecomponentfactory;

	public BronzeBundleShop() {
		this.bronzebundlecomponentfactory = new BronzeBundleComponentFactory();
	}

	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.bronzebundlecomponentfactory);

		return bundle;

	}
}
