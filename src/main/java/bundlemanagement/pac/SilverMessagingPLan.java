package bundlemanagement.pac;

public class SilverMessagingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public SilverMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "5K Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+25;
	}

}
