package bundlemanagement.preconf;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

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
	public CallingPlanOptions createCallingPlan() {

		return CallingPlanOptions.SILVER;
	}

	/**
	 * This method return instance of silver messaging plan.
	 * 
	 * @return messaging plan to preconf class to create silver preconf plan.
	 */
	public MessagingPlanOptions createMessagingPlan() {

		return MessagingPlanOptions.SILVER;
	}

	/**
	 * This method return instance of silver data plan.
	 * 
	 * @return data plan to preconf class to create silver preconf plan.
	 */
	public DataPlanOptions createDataPlan() {

		return DataPlanOptions.SILVER;
	}

	/**
	 * This method returns silver monthly fee for silver preconf plan.
	 * 
	 * @return Monthly fee to preconf class to create silver preconf plan.
	 */
	public BigDecimal createMonthlyFees() {

		return BundleFees.preconfFees.get(BundleNames.SILVER);
	}

	/**
	 * This method returns the name for preconf silver plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create silver preconf plan.
	 */
	public BundleNames createBundleNames() {

		return BundleNames.SILVER;
	}

}
