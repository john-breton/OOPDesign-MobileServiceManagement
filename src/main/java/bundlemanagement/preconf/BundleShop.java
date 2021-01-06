package bundlemanagement.preconf;

public abstract class BundleShop {

	/**
	 * This method will create Bundle at it's related BundleShop.
	 * 
	 * @return Bundle
	 */
	protected abstract PreconfBundle createBundle();

	/**
	 * This method will create Bundle at it's related BundleShop. This method will
	 * ask Bundle to prepare related component for bundle.
	 * 
	 * @param type the type can be gold, platinum, bronze, and silver
	 * @return Bundle
	 */
	public PreconfBundle orderBundle(String name) {

		PreconfBundle bundle = createBundle();
		bundle.setName(name);
		//System.out.println("Making a " + bundle.getName() + "....");
		bundle.prepare();
		return bundle;
	}
}
