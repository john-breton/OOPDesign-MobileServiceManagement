package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class SilverCallingPLan extends BundleDecorator implements CallingPlan{
	
	PaCBundle pacbundle;
	
	public SilverCallingPLan() {
	}

	public SilverCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Silver: 100 min free Canada wide calling";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+20;
	}
	
	public String toString() 
	{
		return "100 min free Canada wide calling";
	}

}
