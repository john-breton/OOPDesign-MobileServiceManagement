package bundlemanagement.pac;

public class ZeroDataPlan extends BundleDecorator {

	final PaCBundle pacbundle;
	private static final int ZERO_DATA_QUANTITY = 0;
	private static final int ZERO_DATA_PLAN_FEE = 0;
	private static final String ZERO_DATA_DESCRIPTION = "Zero Data Plan: Data Included: 0 GB";

	public ZeroDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		return pacbundle.getDescription() + ZERO_DATA_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		return pacbundle.cost() + ZERO_DATA_PLAN_FEE;
	}

	public int getDataQuantity() {
		return ZERO_DATA_QUANTITY;
	}

}
