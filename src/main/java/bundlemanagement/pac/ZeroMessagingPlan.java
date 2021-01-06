package bundlemanagement.pac;

public class ZeroMessagingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;
	private static final int ZERO_NUMBER_OF_MESSAGES = 0;
	private static final int ZERO_MESSAGING_PLAN_FEE = 0;
	private static final String GOLD_MESSAGING_DESCRIPTION = "Zero: Zero Messages";

	public ZeroMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {

		return pacbundle.getDescription() + GOLD_MESSAGING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {

		return pacbundle.cost() + ZERO_MESSAGING_PLAN_FEE;
	}

	public int getDataQuantity() {

		return ZERO_NUMBER_OF_MESSAGES;
	}

}
