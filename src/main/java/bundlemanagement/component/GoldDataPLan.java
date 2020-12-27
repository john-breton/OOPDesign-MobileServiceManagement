package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;


public class GoldDataPLan extends BundleDecorator implements DataPlan{
	
	PaCBundle pacbundle;

	public GoldDataPLan() {
	}
	
	public GoldDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Gold: Data Included: 7 GB ";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+30;
	}
	
	public String toString() 
	{
		return "4 GB";
	}

}
