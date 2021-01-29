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
	 * @param option  Preconfigured Bundle Option
	 * @return        The Preconfigured Bundle Object
	 */
	public PreconfBundle createBundle(BundleNames option) {
		PreconfBundle bundle;
		switch (option) {
			case PLATINUM:
				BundleShop platinumStore = new PlatinumBundleShop();
				bundle = platinumStore.orderBundle();
				break;
			case GOLD:
				BundleShop goldStore = new GoldBundleShop();
				bundle = goldStore.orderBundle();
				break;
			case SILVER:
				BundleShop silverStore = new SilverBundleShop();
				bundle = silverStore.orderBundle();
				break;
			case BRONZE:
				BundleShop bronzeStore = new BronzeBundleShop();
				bundle = bronzeStore.orderBundle();
				break;
			default:
				bundle = null;
				break;
		}
		return bundle;
	}

}
