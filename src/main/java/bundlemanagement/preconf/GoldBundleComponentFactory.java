package bundlemanagement.preconf;

import bundlemanagement.component.*;

public class GoldBundleComponentFactory implements BundleComponentFactory {

	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new GoldCallingPlan();
	}

	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new GoldMessagingPlan();
	}

	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new GoldDataPlan();
	}

	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new GoldMonthlyFees();
	}

}
