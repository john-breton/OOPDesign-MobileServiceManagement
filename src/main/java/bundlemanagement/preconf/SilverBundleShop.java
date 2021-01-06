package bundlemanagement.preconf;

public class SilverBundleShop extends BundleShop {
	private BundleComponentFactory silverbundlecomponentfactory;

	public SilverBundleShop() {
		this.silverbundlecomponentfactory = new SilverBundleComponentFactory();
	}

	protected PreconfBundle createBundle() {
		PreconfBundle bundle;
		bundle = new PreconfBundle(this.silverbundlecomponentfactory);

		return bundle;

	}
}
