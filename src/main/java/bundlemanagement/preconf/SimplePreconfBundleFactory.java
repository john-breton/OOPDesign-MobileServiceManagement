package bundlemanagement.preconf;

import bundlemanagement.service.*;

public class SimplePreconfBundleFactory implements SimpleBundleFactory {
	public Bundle createBundle(BundleOption option) {
		Bundle bundle = null;
		switch (option) {
			case PLATINUM:
				BundleShop platinumStore = new PlatinumBundleShop();
				bundle = platinumStore.orderBundle();
				System.out.println("we ordered a  " + bundle + "\n");
				break;
			case GOLD:
				BundleShop goldStore = new GoldBundleShop();
				bundle = goldStore.orderBundle();
				System.out.println("we ordered a  " + bundle + "\n");
				break;
			case SILVER:
				BundleShop silverStore = new SilverBundleShop();
				bundle = silverStore.orderBundle();
				System.out.println("we ordered a  " + bundle + "\n");
				break;
			case BRONZE:
				BundleShop bronzeStore = new BronzeBundleShop();
				bundle = bronzeStore.orderBundle();
				System.out.println("we ordered a  " + bundle + "\n");
				break;
			default:
				System.out.println("Sorry, we don't have this calling option.");
				break;
		}
		return bundle;
	}

}
