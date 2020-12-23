package bundlemanagement.pac;

public class GoldDataPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public GoldDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Gold: Data Included: 7 GB ";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+30;
	}

}
