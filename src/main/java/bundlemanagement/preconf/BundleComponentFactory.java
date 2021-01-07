package bundlemanagement.preconf;

public interface BundleComponentFactory {
	// responsible to create component for every bundle
	CallingPlan createCallingPlan();

	MessagingPlan createMessagingPlan();

	DataPlan createDataPaln();

	MonthlyFees createMonthlyFees();
}
