package bundlemanagement.preconf;

/**
 * This a bundle shop class is an abstract class to four Bronze, Platinum, Gold,
 * and Silver bundle shops.
 * 
 * @author epahram
 *
 */

public abstract class BundleShop {

	/**
	 * This method will create Bundle at it's related BundleShop. This will be
	 * implemented inside BundleShop concrete classes. All inherited concrete
	 * classes will ask PreconfBundle to provide all bundle needed component for
	 * them.
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
		// System.out.println("Making a " + bundle.getName() + "....");
		bundle.prepare();
		return bundle;
	}
}
