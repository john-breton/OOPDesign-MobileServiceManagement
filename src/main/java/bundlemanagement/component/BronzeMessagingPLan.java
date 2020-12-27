package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BronzeMessagingPLan extends BundleDecorator implements MessagingPlan{
	
	PaCBundle pacbundle;
	
	public BronzeMessagingPLan() {
	}

	public BronzeMessagingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "250 Messages";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+20;
	}
	
	public String toString() 
	{
		return "250 Messages";
	}

}
