package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BronzeDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int BRONZE_DATA_QUANTITY = 2;
	private static final int BRONZE_DATA_PLAN_FEE = 20;
	private static final String BRONZE_DATA_DESCRIPTION = "Bronze: Data Included: 2 GB";

	public BronzeDataPlan() {
	}

	public BronzeDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + BRONZE_DATA_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + BRONZE_DATA_PLAN_FEE;
	}

	public String toString() {
		return "2 GB";
	}

	public int getDataQuantity() {
		// TODO Auto-generated method stub
		return BRONZE_DATA_QUANTITY;
	}

}
