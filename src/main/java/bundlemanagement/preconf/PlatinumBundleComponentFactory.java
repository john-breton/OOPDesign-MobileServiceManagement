package bundlemanagement.preconf;

import bundlemanagement.component.*;

/**
 * This Class implements Platinum Bundle Component Factory.
 * 
 * It will return instance of platinum related components to preconfBundle in
 * order to make platinum preconf plan.
 * 
 * @author epahram
 *
 */

public class PlatinumBundleComponentFactory implements BundleComponentFactory {

	/**
	 * This method return instance of platinum calling plan.
	 * 
	 * @return calling plan to PreconfBundle class to create platinum preconf plan.
	 */
	public CallingPlan createCallingPlan() {

		return new PlatinumCallingPlan();
	}

	/**
	 * This method return instance of platinum messaging plan.
	 * 
	 * @return messaging plan to PreconfBundle class to create platinum preconf
	 *         plan.
	 */
	public MessagingPlan createMessagingPlan() {

		return new PlatinumMessagingPlan();
	}

	/**
	 * This method return instance of platinum data plan.
	 * 
	 * @return data plan to PreconfBundle class to create platinum preconf plan.
	 */
	public DataPlan createDataPlan() {

		return new PlatinumDataPlan();
	}

	/**
	 * This method return instance of platinum monthly fee for platinum preconf
	 * plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create platinum preconf plan.
	 */
	public MonthlyFees createMonthlyFees() {

		return new PlatinumMonthlyFees();
	}

}
