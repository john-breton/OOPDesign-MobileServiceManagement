package bundlemanagement.pac;

public class PlatinumDataPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public PlatinumDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Platinum: Data Included: 10 GB";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+40;
	}

}
