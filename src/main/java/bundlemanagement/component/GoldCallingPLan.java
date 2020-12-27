package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;


public class GoldCallingPLan extends BundleDecorator implements CallingPlan{
	
	PaCBundle pacbundle;

	public GoldCallingPLan() {
	}
	
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
	
	public String toString() 
	{
		return "Unlimited Canada wide calling";
	}

}
