package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BronzeCallingPLan extends BundleDecorator implements CallingPlan{
	
	PaCBundle pacbundle;
	
	//This constructor use for Preconfigured Bundle side.
	public BronzeCallingPLan() {
	}

	////This constructor use for PaC Bundle side.
	public BronzeCallingPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	//This method use for PaC side.
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ "Bronze: 30 min free Canada wide calling";
	}

	//This method use for PaC side. 
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+15;
	}
	
	
	//This Method use for Preconf side. 
	public String toString() 
	{
		return "30 min free Canada wide calling";
	}

}
