package bundlemanagement.preconf;

import bundlemanagement.component.*;

public class GoldBundleComponentFactory implements BundleComponentFactory {

	public CallingPlan createCallingPlan() {

		return new GoldCallingPlan();
	}

	public MessagingPlan createMessagingPlan() {

		return new GoldMessagingPlan();
	}

	public DataPlan createDataPaln() {

		return new GoldDataPlan();
	}

	public MonthlyFees createMonthlyFees() {
		return new GoldMonthlyFees();
	}

}
