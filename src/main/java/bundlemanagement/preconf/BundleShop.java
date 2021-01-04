package bundlemanagement.preconf;

public abstract class BundleShop {
	protected abstract PreconfBundle createBundle();

	public Bundle orderBundle() {
		PreconfBundle bundle = createBundle();
		System.out.println("Making a " + bundle.getName() + "....");
		bundle.prepare();
		return bundle;
	}
}
