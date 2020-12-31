package bundlemanagement.preconf;

public abstract class BundleShop {
	protected abstract Bundle createBundle();

	public Bundle orderBundle(String type) {
		Bundle bundle = createBundle();
		System.out.println("Making a " + bundle.getName() + "....");
		bundle.prepare();
		return bundle;
	}
}
