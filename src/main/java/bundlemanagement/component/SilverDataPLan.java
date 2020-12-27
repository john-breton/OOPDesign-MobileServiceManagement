package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class SilverDataPLan extends BundleDecorator implements DataPlan{
	
	PaCBundle pacbundle;

	public SilverDataPLan() {
	}
	
	public SilverDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Silver: Data Included: 4 GB ";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+25;
	}
	
	public String toString() 
	{
		return "2 GB";
	}

}
