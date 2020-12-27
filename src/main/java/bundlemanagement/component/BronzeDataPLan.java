package bundlemanagement.component;
import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BronzeDataPLan extends BundleDecorator implements DataPlan{
	
	PaCBundle pacbundle;
	
	public BronzeDataPLan() {
	}
	
	public BronzeDataPLan(PaCBundle pacbundle) 
	{
		this.pacbundle=pacbundle;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription()+ " Bronze: Data Included: 2 GB";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost()+20;
	}
	
	public String toString() 
	{
		return "1 GB";
	}

}
