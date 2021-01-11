package bundlemanagement.pac;

/**
 * This class implements Zero calling plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroCallingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;
	private static final int ZERO_CALLING_MINUTES = 0;
	private static final int ZERO_CALLING_PLAN_FEE = 0;
	private static final String ZERO_CALLING_DESCRIPTION = "Calling Plan: Zero - Zero min";

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * Sets description for zero calling plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + ZERO_CALLING_DESCRIPTION + "\n";
	}

	/**
	 * Sets fee for zero calling plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + ZERO_CALLING_PLAN_FEE;
	}

	/**
	 * Sets minutes for PaC bundle.
	 * 
	 * @return calling minutes time to PaC bundle.
	 */
	public int getCallingMinutes() {

		return ZERO_CALLING_MINUTES;
	}

}
