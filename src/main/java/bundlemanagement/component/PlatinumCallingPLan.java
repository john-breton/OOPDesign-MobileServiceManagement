package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class PlatinumCallingPLan extends BundleDecorator implements CallingPlan{
	
	PaCBundle pacbundle;
	
	public PlatinumCallingPLan() {
	}

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
	
	public String toString() 
	{
		return "Unlimited US & Canada wide calling";
	}

}
