package bundlemanagement.preconf;

public class PreconfTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create specific bundle shop.
		BundleShop goldStore = new GoldBundleShop();
		Bundle bundle = goldStore.orderBundle();
		System.out.println("we ordered a  " + bundle + "\n");

		BundleShop platinumStore = new PlatinumBundleShop();
		Bundle bundle1 = platinumStore.orderBundle();
		System.out.println("we ordered a  " + bundle1 + "\n");

		BundleShop bronzeStore = new BronzeBundleShop();
		Bundle bundle2 = bronzeStore.orderBundle();
		System.out.println("we ordered a  " + bundle2 + "\n");

	}

}
