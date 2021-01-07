package bundlemanagement.preconf;
import bundlemanagement.service.*;



/**
 * This SimplePreconfBundleFactory creates Preconfigured Bundle
 * @author enuyhza
 *
 */
public class SimplePreconfBundleFactory{
	/**
	 * Create Preconfigured Bundle based on passing parameters
	 * @param name    Bundle Name
	 * @param option  Preconfigured Bundle Option
	 * @return        The Preconfigured Bundle Object
	 */
	public PreconfBundle createBundle(String name, BundleOption option) {
		PreconfBundle bundle;
		switch (option) {
			case PLATINUM:
				BundleShop platinumStore = new PlatinumBundleShop();
				bundle = platinumStore.orderBundle(name);
				break;
			case GOLD:
				BundleShop goldStore = new GoldBundleShop();
				bundle = goldStore.orderBundle(name);
				break;
			case SILVER:
				BundleShop silverStore = new SilverBundleShop();
				bundle = silverStore.orderBundle(name);
				break;
			case BRONZE:
				BundleShop bronzeStore = new BronzeBundleShop();
				bundle = bronzeStore.orderBundle(name);
				break;
			default:
				bundle = null;
				break;
		}
		return bundle;
	}

}
