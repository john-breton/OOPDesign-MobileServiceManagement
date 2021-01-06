package bundlemanagement.preconf;

public class PreconfBundle extends Bundle {
	BundleComponentFactory ComponentFactory;

	/**
	 * The constructor will set the value for related BundleComponentFactory.
	 * 
	 * @param ComponentFactory
	 */

	public PreconfBundle(BundleComponentFactory ComponentFactory) {
		this.ComponentFactory = ComponentFactory;
	}

	/**
	 * It will prepare prepare component for it's related bundle plan through
	 * calling proper BundleComponentFactory
	 */
	void prepare() {
		System.out.println("Preparing " + Name);
		callingplan = ComponentFactory.createCallingPlan();
		messagingplan = ComponentFactory.createMessagingPlan();
		dataplan = ComponentFactory.createDataPaln();
		monthlyfees = ComponentFactory.createMonthlyFees();
	}
}
