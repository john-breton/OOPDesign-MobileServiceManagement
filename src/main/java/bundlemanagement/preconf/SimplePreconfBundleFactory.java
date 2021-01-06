package bundlemanagement.preconf;
import bundlemanagement.service.*;



public class SimplePreconfBundleFactory{
	public PreconfBundle createBundle(String name, BundleOption option) {
		PreconfBundle bundle;
		switch (option) {
			case PLATINUM:
				BundleShop platinumStore = new PlatinumBundleShop();
				bundle = platinumStore.orderBundle(name);
				//System.out.println("we ordered a  \n" + bundle + "\n");
				break;
			case GOLD:
				BundleShop goldStore = new GoldBundleShop();
				bundle = goldStore.orderBundle(name);
				//System.out.println("we ordered a  " + bundle + "\n");
				break;
			case SILVER:
				BundleShop silverStore = new SilverBundleShop();
				bundle = silverStore.orderBundle(name);
				//System.out.println("we ordered a  " + bundle + "\n");
				break;
			case BRONZE:
				BundleShop bronzeStore = new BronzeBundleShop();
				bundle = bronzeStore.orderBundle(name);
				//System.out.println("we ordered a  " + bundle + "\n");
				break;
			default:
				bundle = null;
				break;
		}
		return bundle;
	}

}
