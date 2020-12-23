package bundlemanagement.preconf;

public class SilverBundleShop extends BundleStore{
	
	protected Bundle createBundle(String item) 
	{
		Bundle bundle=null;
		
		BundleComponentFactory componentfactory=new SilverBundleComponentFactory();
		bundle=new PreconfBundle(componentfactory);
		bundle.setName("Silver Bundle: \n");
		
		return bundle;
		
	}
}
