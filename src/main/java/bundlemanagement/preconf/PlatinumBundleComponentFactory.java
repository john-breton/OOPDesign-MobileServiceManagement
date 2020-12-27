package bundlemanagement.preconf;
import bundlemanagement.component.*;

public class PlatinumBundleComponentFactory implements BundleComponentFactory{


	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new PlatinumCallingPLan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new PlatinumMessagingPLan();
	}

	
	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new PlatinumDataPLan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new PlatinumMonthlyFees();
	}

}
