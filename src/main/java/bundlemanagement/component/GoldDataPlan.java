package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class GoldDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int GOLD_DATA_QUANTITY = 4;
	private static final int GOLD_DATA_PLAN_FEE = 30;
	private static final String GOLD_DATA_DESCRIPTION = "Data Plan: Gold - Data Included: 7 GB";

	public GoldDataPlan() {
	}

	public GoldDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {

		return pacbundle.getDescription() + GOLD_DATA_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {

		return pacbundle.cost() + GOLD_DATA_PLAN_FEE;
	}

	public String toString() {
		return "4 GB";
	}

	public int getDataQuantity() {

		return GOLD_DATA_QUANTITY;
	}

}
