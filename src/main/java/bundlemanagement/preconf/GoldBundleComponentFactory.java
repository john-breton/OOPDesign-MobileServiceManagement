package bundlemanagement.preconf;
import bundlemanagement.component.*;



public class GoldBundleComponentFactory implements BundleComponentFactory{
	
	
	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new GoldCallingPLan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new GoldMessagingPLan();
	}

	
	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new GoldDataPLan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new GoldMonthlyFees();
	}

}
