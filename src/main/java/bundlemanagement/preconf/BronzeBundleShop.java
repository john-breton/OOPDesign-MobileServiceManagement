package bundlemanagement.preconf;

public class BronzeBundleShop extends BundleStore{
	
	protected Bundle createBundle(String item) 
	{
		Bundle bundle=null;
		
		BundleComponentFactory componentfactory=new BronzeBundleComponentFactory();
		bundle=new PreconfBundle(componentfactory);
		bundle.setName("Bronze Bundle: \n");
		
		return bundle;
		
	}
}
