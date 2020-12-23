package bundlemanagement.pac;

public class PlatinumCallingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public PlatinumCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ " Platinum: Unlimited US & Canada wide calling";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+40;
	}

}
