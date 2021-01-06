package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class SilverCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int SILVER_CALLING_MINUTES = 100;
	private static final int SILVER_CALLING_PLAN_FEE = 20;
	private static final String SILVER_CALLING_DESCRIPTION = "Silver: 100 min free Canada wide calling";

	public SilverCallingPlan() {
	}

	public SilverCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {

		return pacbundle.getDescription() + SILVER_CALLING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {

		return pacbundle.cost() + SILVER_CALLING_PLAN_FEE;
	}

	public String toString() {
		return "100 min free Canada wide calling";
	}

	public int getCallingMinutes() {

		return SILVER_CALLING_MINUTES;
	}

}
