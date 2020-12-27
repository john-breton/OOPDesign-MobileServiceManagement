package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class PlatinumDataPLan extends BundleDecorator implements DataPlan{
	
	PaCBundle pacbundle;
	
	public PlatinumDataPLan() {
	}

	public PlatinumDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Platinum: Data Included: 10 GB";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+40;
	}
	
	public String toString() 
	{
		return "10 GB";
	}
}
