package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class GoldMessagingPLan extends BundleDecorator implements MessagingPlan{
	
	PaCBundle pacbundle;
	
	public GoldMessagingPLan() {
	}

	public GoldMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "10k Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+35;
	}
	
	public String toString() 
	{
		return "10K Messages";
	}

}
