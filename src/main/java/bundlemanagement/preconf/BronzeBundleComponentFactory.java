package bundlemanagement.preconf;

public class BronzeBundleComponentFactory implements BundleComponentFactory{

	
	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new BronzeCallingPlan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new BronzeMessagingPlan();
	}

	
	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new BronzeDataPlan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new BronzeMonthlyFees();
	}

}
