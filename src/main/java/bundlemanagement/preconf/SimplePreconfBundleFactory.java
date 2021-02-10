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
            case PLATINUM -> {
                BundleShop platinumStore = new PlatinumBundleShop();
                bundle = platinumStore.orderBundle();
            }
            case GOLD -> {
                BundleShop goldStore = new GoldBundleShop();
                bundle = goldStore.orderBundle();
            }
            case SILVER -> {
                BundleShop silverStore = new SilverBundleShop();
                bundle = silverStore.orderBundle();
            }
            case BRONZE -> {
                BundleShop bronzeStore = new BronzeBundleShop();
                bundle = bronzeStore.orderBundle();
            }
            default -> bundle = null;
        }
		return bundle;
	}

}
