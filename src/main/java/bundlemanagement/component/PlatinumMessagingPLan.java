package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class PlatinumMessagingPLan extends BundleDecorator implements MessagingPlan{
	
	PaCBundle pacbundle;
	
	public PlatinumMessagingPLan() {
	}

	public PlatinumMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Unlimited Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+45;
	}
	
	public String toString() 
	{
		return "Unlimited Messages";
	}

}
