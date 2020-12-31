package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class SilverDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int SILVER_DATA_QUANTITY = 2;
	private static final int SILVER_DATA_PLAN_FEE = 25;
	private static final String SILVER_DATA_DESCRIPTION = "Silver: Data Included: 4 GB";

	public SilverDataPlan() {
	}

	public SilverDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + SILVER_DATA_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + SILVER_DATA_PLAN_FEE;
	}

	public String toString() {
		return "2 GB";
	}

	public int getDataQuantity() {
		// TODO Auto-generated method stub
		return SILVER_DATA_QUANTITY;
	}

}
