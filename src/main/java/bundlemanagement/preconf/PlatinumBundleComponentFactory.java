package bundlemanagement.preconf;

public class PlatinumBundleComponentFactory implements BundleComponentFactory{


	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new PlatinumCallingPlan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new PlatinumMessagingPlan();
	}

	
	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new PlatinumDataPlan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new PlatinumMonthlyFees();
	}

}
