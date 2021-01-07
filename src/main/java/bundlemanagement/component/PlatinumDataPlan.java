package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class PlatinumDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int PLATINUM_DATA_QUANTITY = 10;
	private static final int PLATINUM_DATA_PLAN_FEE = 40;
	private static final String PLATINUM_DATA_DESCRIPTION = "Data Plan: Platinum - Data Included: 10 GB";

	public PlatinumDataPlan() {
	}

	public PlatinumDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {

		return pacbundle.getDescription() + PLATINUM_DATA_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {

		return pacbundle.cost() + PLATINUM_DATA_PLAN_FEE;
	}

	public String toString() {
		return "10 GB";
	}

	public int getDataQuantity() {

		return PLATINUM_DATA_QUANTITY;
	}
}
