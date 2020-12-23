package bundlemanagement.pac;

public class GoldMessagingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public GoldMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "10k Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+35;
	}

}
