package bundlemanagement.pac;

public class PlatinumMessagingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public PlatinumMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Unlimited Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+45;
	}

}
