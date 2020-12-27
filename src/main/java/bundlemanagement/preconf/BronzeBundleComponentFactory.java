package bundlemanagement.preconf;
import bundlemanagement.component.*;

public class BronzeBundleComponentFactory implements BundleComponentFactory{

	
	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new BronzeCallingPLan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new BronzeMessagingPLan();
	}

	
	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new BronzeDataPLan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new BronzeMonthlyFees();
	}

}
