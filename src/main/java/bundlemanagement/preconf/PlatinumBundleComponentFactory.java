package bundlemanagement.preconf;

import java.math.BigDecimal;

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
	 * This method returns platinum calling plan from CallingPlanOptions enum class.
	 * 
	 * @return Platinum calling plan to PreconfBundle class to create platinum
	 *         preconf plan.
	 */
	public CallingPlanOptions createCallingPlan() {

		return CallingPlanOptions.PLATINUM;
	}

	/**
	 * This method returns platinum messaging plan from MessagingPlanOptions enum
	 * class.
	 * 
	 * @return Platinum messaging plan to PreconfBundle class to create platinum
	 *         preconf plan.
	 */
	public MessagingPlanOptions createMessagingPlan() {

		return MessagingPlanOptions.PLATINUM;
	}

	/**
	 * This method returns platinum data plan from DataPlanOptions enum class.
	 * 
	 * @return Platinum data plan to PreconfBundle class to create platinum preconf
	 *         plan.
	 */
	public DataPlanOptions createDataPlan() {

		return DataPlanOptions.PLATINUM;
	}

	/**
	 * This method returns platinum monthly fee for platinum preconf plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create platinum preconf plan.
	 */
	public BigDecimal createMonthlyFees() {

		return BundleFees.preconfFees.get(BundleNames.PLATINUM);
	}

	/**
	 * This method returns the name for preconf platinum plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create platinum preconf plan.
	 */
	public BundleNames createBundleNames() {

		return BundleNames.PLATINUM;
	}

}
