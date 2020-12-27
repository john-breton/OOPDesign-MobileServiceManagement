package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class SilverMessagingPLan extends BundleDecorator implements MessagingPlan{
	
	PaCBundle pacbundle;
	
	public SilverMessagingPLan() {
	}

	public SilverMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "5K Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+25;
	}
	
	public String toString() 
	{
		return "5K Messages";
	}

}
