package bundlemanagement.preconf;

public class PreconfBundle extends Bundle {
	BundleComponentFactory ComponentFactory;

	public PreconfBundle(BundleComponentFactory ComponentFactory) {
		this.ComponentFactory = ComponentFactory;
	}

	void prepare() {
		// the prepare method asks factories to create different component of the plan
		System.out.println("Preparing " + Name);
		callingplan = ComponentFactory.createCallingPlan();
		messagingplan = ComponentFactory.createMessagingPlan();
		dataplan = ComponentFactory.createDataPaln();
		monthlyfees = ComponentFactory.createMonthlyFees();
	}
}
