package bundlemanagement.pac;

public class SilverCallingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public SilverCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Silver: 100 min free Canada wide calling";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+20;
	}

}
