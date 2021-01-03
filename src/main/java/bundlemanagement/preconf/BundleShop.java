package bundlemanagement.preconf;

public abstract class BundleShop {
	protected abstract PreconfBundle createBundle();

	public Bundle orderBundle(String type) {
		PreconfBundle bundle = createBundle();
		System.out.println("Making a " + bundle.getName() + "....");
		bundle.prepare();
		return bundle;
	}
}
