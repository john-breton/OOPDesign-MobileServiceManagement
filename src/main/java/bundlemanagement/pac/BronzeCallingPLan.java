package bundlemanagement.pac;

public class BronzeCallingPLan extends BundleDecorator{
	
	PaCBundle pacbundle;

	public BronzeCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Bronze: 30 min free Canada wide calling";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+15;
	}

}
