package bundlemanagement.preconf;

public class SilverBundleComponentFactory implements BundleComponentFactory{

	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new SilverCallingPlan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new SilverMessagingPlan();
	}


	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new SilverDataPlan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new SilverMonthlyFees();
	}

}
