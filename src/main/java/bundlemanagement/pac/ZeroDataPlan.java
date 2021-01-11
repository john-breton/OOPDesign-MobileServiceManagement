package bundlemanagement.pac;

/**
 * This class implements Zero data plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroDataPlan extends BundleDecorator {

	final PaCBundle pacbundle;
	private static final int ZERO_DATA_QUANTITY = 0;
	private static final int ZERO_DATA_PLAN_FEE = 0;
	private static final String ZERO_DATA_DESCRIPTION = "Data Plan: Zero - Data Included: 0 GB";

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * Sets description for zero data plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + ZERO_DATA_DESCRIPTION + "\n";
	}

	/**
	 * Sets fee for zero data plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + ZERO_DATA_PLAN_FEE;
	}

	/**
	 * Sets data quantity for zero data plan.
	 * 
	 * @return data quantity to PaC bundle.
	 */
	public int getDataQuantity() {

		return ZERO_DATA_QUANTITY;
	}

}
