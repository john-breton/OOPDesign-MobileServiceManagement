package bundlemanagement.preconf;

public class PlatinumBundleShop extends BundleStore{
	
	protected Bundle createBundle(String item) 
	{
		Bundle bundle=null;
		
		BundleComponentFactory componentfactory=new PlatinumBundleComponentFactory();
		bundle=new PreconfBundle(componentfactory);
		bundle.setName("Platinum Bundle: \n");
		
		return bundle;
		
	}
}
