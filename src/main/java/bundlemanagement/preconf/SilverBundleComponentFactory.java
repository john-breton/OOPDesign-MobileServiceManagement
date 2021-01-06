package bundlemanagement.preconf;

import bundlemanagement.component.*;

public class SilverBundleComponentFactory implements BundleComponentFactory {

	public CallingPlan createCallingPlan() {

		return new SilverCallingPlan();
	}

	public MessagingPlan createMessagingPlan() {

		return new SilverMessagingPlan();
	}

	public DataPlan createDataPaln() {

		return new SilverDataPlan();
	}

	public MonthlyFees createMonthlyFees() {

		return new SilverMonthlyFees();
	}

}
