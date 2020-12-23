package bundlemanagement.preconf;

public interface BundleComponentFactory {
	//responsible to create component for every bundle
	public CallingPlan createCallingPlan();
	public MessagingPlan createMessagingPlan();
	public DataPlan createDataPaln();
	public MonthlyFees createMonthlyFees();
}
