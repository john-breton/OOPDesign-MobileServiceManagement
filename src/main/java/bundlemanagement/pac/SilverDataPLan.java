package bundlemanagement.pac;

public class SilverDataPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public SilverDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Silver: Data Included: 4 GB ";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+25;
	}

}
