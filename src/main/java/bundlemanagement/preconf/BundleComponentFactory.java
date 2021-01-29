package bundlemanagement.preconf;

import java.math.BigDecimal;

import bundlemanagement.service.BundleNames;

/**
 * This an interface class to create bundle components such as callingS plan,
 * messaging plan, data plan, and monthly fee.
 * 
 * This class has four children, and each children will create component for
 * their related plan.
 * 
 * @author epahram
 *
 */

public interface BundleComponentFactory {
	// responsible to create component for every bundle
	BundleNames createBundleNames();

	CallingPlanOptions createCallingPlan();

	MessagingPlanOptions createMessagingPlan();

	DataPlanOptions createDataPlan();

	BigDecimal createMonthlyFees();
}
