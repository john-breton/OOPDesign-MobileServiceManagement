package bundlemanagement.preconf;

public abstract class BundleStore {
	protected abstract Bundle createBundle(String item);
	 
	public Bundle orderBundle(String type) {
		Bundle bundle = createBundle(type);
		System.out.println("--- Making a " + bundle.getName() + " ---");
		bundle.prepare();
		return bundle;
	}
}
