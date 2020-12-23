package bundlemanagement.pac;

public class ZeroCallingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public ZeroCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ " Zero min";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+0;
	}

}
