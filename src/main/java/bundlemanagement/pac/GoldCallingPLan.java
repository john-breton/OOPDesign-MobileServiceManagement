package bundlemanagement.pac;

public class GoldCallingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public GoldCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Gold: Unlimited Canada wide calling";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+30;
	}

}
