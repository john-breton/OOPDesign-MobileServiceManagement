package bundlemanagement.preconf;

public class BundleTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create specific bundle shop. 
		BundleStore goldStore = new GoldBundleShop();
		Bundle bundle = goldStore.orderBundle("Gold");
		System.out.println("we ordered a  " + bundle + "\n");
 
		BundleStore platinumStore = new PlatinumBundleShop();
		Bundle bundle1 = platinumStore.orderBundle("platinum");
		System.out.println("we ordered a  " + bundle1 + "\n");
		
		BundleStore bronzeStore = new BronzeBundleShop();
		Bundle bundle2 = bronzeStore.orderBundle("bronze");
		System.out.println("we ordered a  " + bundle2 + "\n");


	}

}
