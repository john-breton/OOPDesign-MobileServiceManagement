package bundlemanagement.pac;

public class ZeroMessagingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public ZeroMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ " Zero Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+0;
	}

}
