package bundlemanagement.preconf;

import bundlemanagement.component.*;

public class PlatinumBundleComponentFactory implements BundleComponentFactory {

	/**
	 * It will return PlatinumCallingPlan
	 * 
	 * @return CallingPlan
	 */
	public CallingPlan createCallingPlan() {

		return new PlatinumCallingPlan();
	}

	/**
	 * It will return PlatinumMessagingPlan
	 * 
	 * @return MessagingPlan
	 */

	public MessagingPlan createMessagingPlan() {

		return new PlatinumMessagingPlan();
	}

	/**
	 * It will return PlatinumDataPlan
	 * 
	 * @return DataPlan
	 */

	public DataPlan createDataPaln() {

		return new PlatinumDataPlan();
	}

	/**
	 * It will return PlatinumMonthlyFees
	 * 
	 * @return MonthlyFees
	 */
	public MonthlyFees createMonthlyFees() {

		return new PlatinumMonthlyFees();
	}

}
