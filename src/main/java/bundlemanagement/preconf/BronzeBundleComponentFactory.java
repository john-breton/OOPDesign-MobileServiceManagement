package bundlemanagement.preconf;

import bundlemanagement.component.*;

public class BronzeBundleComponentFactory implements BundleComponentFactory {

	public CallingPlan createCallingPlan() {

		return new BronzeCallingPlan();
	}

	public MessagingPlan createMessagingPlan() {

		return new BronzeMessagingPlan();
	}

	public DataPlan createDataPaln() {

		return new BronzeDataPlan();
	}

	public MonthlyFees createMonthlyFees() {

		return new BronzeMonthlyFees();
	}

}
