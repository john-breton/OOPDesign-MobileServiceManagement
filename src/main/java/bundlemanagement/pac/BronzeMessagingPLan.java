package bundlemanagement.pac;

public class BronzeMessagingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public BronzeMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "250 Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+20;
	}

}
