package bundlemanagement.pac;

public class BronzeDataPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public BronzeDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ " Bronze: Data Included: 2 GB";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+20;
	}

}
