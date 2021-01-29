package bundlemanagement.preconf;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This Class implements Bronze Bundle Component Factory.
 * 
 * It will return instance of bronze related components to preconfBundle in
 * order to make bronze preconf plan.
 * 
 * @author epahram
 *
 */
public class BronzeBundleComponentFactory implements BundleComponentFactory {

	/**
	 * This method returns Bronze calling plan from CallingPlanOptions enum class.
	 * 
	 * @return Bronze calling plan to PreconfBundle class to create bronze preconf
	 *         plan.
	 */
	public CallingPlanOptions createCallingPlan() {

		return CallingPlanOptions.BRONZE;
	}

	/**
	 * This method returns bronze messaging plan from MessagingPlanOptions enum
	 * class.
	 * 
	 * @return Bronze messaging plan to PreconfBundle class to create bronze preconf
	 *         plan.
	 */
	public MessagingPlanOptions createMessagingPlan() {

		return MessagingPlanOptions.BRONZE;
	}

	/**
	 * This method returns bronze data plan from DataPlanOptions enum class.
	 * 
	 * @return Bronze data plan to PreconfBundle class to create bronze preconf
	 *         plan.
	 */
	public DataPlanOptions createDataPlan() {

		return DataPlanOptions.BRONZE;
	}

	/**
	 * This method returns bronze monthly fee for Bronze preconf plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create bronze preconf plan.
	 */
	public BigDecimal createMonthlyFees() {

		return BundleFees.preconfFees.get(BundleNames.BRONZE);
	}

	/**
	 * This method returns the name for preconf bronze plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create bronze preconf plan.
	 */
	public BundleNames createBundleNames() {

		return BundleNames.BRONZE;
	}

}
