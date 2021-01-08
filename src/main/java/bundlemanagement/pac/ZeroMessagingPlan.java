package bundlemanagement.pac;

/**
 * This class implements Zero messaging plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroMessagingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;
	private static final int ZERO_NUMBER_OF_MESSAGES = 0;
	private static final int ZERO_MESSAGING_PLAN_FEE = 0;
	private static final String ZERO_MESSAGING_DESCRIPTION = "Messaging Plan: Zero - Zero Messages";

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle
	 */
	public ZeroMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * 
	 * Sets description for zero messaging plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + ZERO_MESSAGING_DESCRIPTION + "\n";
	}

	/**
	 * Sets fee for zero messaging plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + ZERO_MESSAGING_PLAN_FEE;
	}

	/**
	 * Sets minutes for PaC bundle.
	 * 
	 * @return number of messages to PaC bundle.
	 */
	public int getNumberOfMessages() {

		return ZERO_NUMBER_OF_MESSAGES;
	}

}
