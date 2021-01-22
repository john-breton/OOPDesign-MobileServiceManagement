package bundlemanagement.preconf;

import java.math.BigDecimal;

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
	 * This method returns gold calling plan from CallingPlanOptions enum class.
	 * 
	 * @return Gold calling plan to PreconfBundle class to create Gold preconf plan.
	 */
	public CallingPlanOptions createCallingPlan() {

		return CallingPlanOptions.GOLD;
	}

	/**
	 * This method returns gold messaging plan from MessagingPlanOptions enum class.
	 * 
	 * @return Gold messaging plan to PreconfBundle class to create gold preconf
	 *         plan.
	 */
	public MessagingPlanOptions createMessagingPlan() {

		return MessagingPlanOptions.GOLD;
	}

	/**
	 * This method returns gold data plan from DataPlanOptions enum class.
	 * 
	 * @return Gold data plan to PreconfBundle class to create gold preconf plan.
	 */
	public DataPlanOptions createDataPlan() {

		return DataPlanOptions.GOLD;
	}

	/**
	 * This method returns gold monthly fee for gold preconf plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create gold preconf plan.
	 */
	// Ista's comment: use Double or Bigdecimal(read about it!!!)
	public BigDecimal createMonthlyFees() {
		return BundleFees.preconfFees.get(BundleNames.GOLD);
	}

	/**
	 * This method returns the name for preconf gold plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create gold preconf plan.
	 */
	public BundleNames createBundleNames() {
		return BundleNames.GOLD;
	}

}
