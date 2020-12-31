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
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + ZERO_DATA_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + ZERO_DATA_PLAN_FEE;
	}

	public int getDataQuantity() {
		// TODO Auto-generated method stub
		return ZERO_DATA_QUANTITY;
	}

}
