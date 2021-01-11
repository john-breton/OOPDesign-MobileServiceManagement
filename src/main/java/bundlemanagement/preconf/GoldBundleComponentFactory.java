package bundlemanagement.preconf;

import bundlemanagement.component.*;

/**
 * This Class implements Gold Bundle Component Factory.
 * 
 * It will return instance of gold related components to preconfBundle in order
 * to make gold preconf plan.
 * 
 * @author epahram
 *
 */
public class GoldBundleComponentFactory implements BundleComponentFactory {

	/**
	 * This method return instance of Gold Calling Plan.
	 * 
	 * @return calling plan to preconf class to create gold preconf plan.
	 */
	public CallingPlan createCallingPlan() {

		return new GoldCallingPlan();
	}

	/**
	 * This method return instance of Gold Messaging Plan.
	 * 
	 * @return messaging plan to preconf class to create gold preconf plan.
	 */
	public MessagingPlan createMessagingPlan() {

		return new GoldMessagingPlan();
	}

	/**
	 * This method return instance Gold Data Plan.
	 * 
	 * @return data plan to preconf class to create gold preconf plan.
	 */
	public DataPlan createDataPlan() {

		return new GoldDataPlan();
	}

	/**
	 * This method return Gold monthly fee for Gold preconf plan.
	 * 
	 * @return Gold Monthly fee to preconf class to create bronze preconf plan.
	 */
	public MonthlyFees createMonthlyFees() {
		return new GoldMonthlyFees();
	}

}
