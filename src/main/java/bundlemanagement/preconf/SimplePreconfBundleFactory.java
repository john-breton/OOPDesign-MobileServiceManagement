package bundlemanagement.preconf;

import bundlemanagement.service.*;

public class SimplePreconfBundleFactory implements SimpleBundleFactory {
	public Bundle createBundle(String name) {
		Bundle bundle = null;
		if (name.equals("Platinum")) {
			BundleShop platinumStore = new PlatinumBundleShop();
			bundle = platinumStore.orderBundle("platinum");
			System.out.println("we ordered a  " + bundle + "\n");
		} else if (name.equals("Gold")) {
			BundleShop goldStore = new GoldBundleShop();
			bundle = goldStore.orderBundle("Gold");
			System.out.println("we ordered a  " + bundle + "\n");
		} else if (name.equals("Silver")) {
			BundleShop silverStore = new SilverBundleShop();
			bundle = silverStore.orderBundle("Gold");
			System.out.println("we ordered a  " + bundle + "\n");
		} else if (name.equals("Bronze")) {
			BundleShop bronzeStore = new BronzeBundleShop();
			bundle = bronzeStore.orderBundle("bronze");
			System.out.println("we ordered a  " + bundle + "\n");
		} else {
			System.out.println("Sorry, we don't have this type of Preconfigured Bundle.");
		}

		return bundle;
	}

}
