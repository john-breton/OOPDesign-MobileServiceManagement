package bundlemanagement.preconf;

/**
 * This an interface class to create bundle components such as callin plan,
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
	CallingPlan createCallingPlan();

	MessagingPlan createMessagingPlan();

	DataPlan createDataPaln();

	MonthlyFees createMonthlyFees();
}
