package bundlemanagement.pac;

public class ZeroDataPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public ZeroDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "ZeroData Plan: Data Included: 0 GB";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+0;
	}

}
