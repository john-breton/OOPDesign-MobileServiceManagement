package bundlemanagement.preconf;

import bundlemanagement.component.*;

/**
 * This Class implements Silver Bundle Component Factory.
 * 
 * It will return instance of silver related components to preconfBundle in
 * order to make silver preconf plan.
 * 
 * @author epahram
 *
 */

public class SilverBundleComponentFactory implements BundleComponentFactory {

	/**
	 * This method return instance of Silver Calling Plan.
	 * 
	 * @return calling plan to preconf class to create silver preconf plan.
	 */
	public CallingPlan createCallingPlan() {

		return new SilverCallingPlan();
	}

	/**
	 * This method return instance of silver messaging plan.
	 * 
	 * @return messaging plan to preconf class to create silver preconf plan.
	 */
	public MessagingPlan createMessagingPlan() {

		return new SilverMessagingPlan();
	}

	/**
	 * This method return instance of silver data plan.
	 * 
	 * @return data plan to preconf class to create silver preconf plan.
	 */
	public DataPlan createDataPlan() {

		return new SilverDataPlan();
	}

	/**
	 * This method return instance of silver monthly fee for silver preconf plan.
	 * 
	 * @return Monthly fee to preconf class to create silver preconf plan.
	 */
	public MonthlyFees createMonthlyFees() {

		return new SilverMonthlyFees();
	}

}
