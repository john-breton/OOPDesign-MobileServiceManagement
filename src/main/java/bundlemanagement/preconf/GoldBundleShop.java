package bundlemanagement.preconf;

public class GoldBundleShop extends BundleStore{
	
	protected Bundle createBundle(String item) 
	{
		Bundle bundle=null;
		BundleComponentFactory componentfactory=new GoldBundleComponentFactory();
		bundle=new PreconfBundle(componentfactory);
		bundle.setName("Gold Bundle: \n");
		
		return bundle;
		
	}
}
