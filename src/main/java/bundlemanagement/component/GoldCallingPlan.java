package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class GoldCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int GOLD_CALLING_MINUTES = Integer.MAX_VALUE;
	private static final int GOLD_CALLING_PLAN_FEE = 30;
	private static final String GOLD_CALLING_DESCRIPTION = "Calling Plan: Gold - Unlimited Canada wide calling";

	public GoldCallingPlan() {
	}

	public GoldCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {

		return pacbundle.getDescription() + GOLD_CALLING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {

		return pacbundle.cost() + GOLD_CALLING_PLAN_FEE;
	}

	public String toString() {
		return "Unlimited Canada wide calling";
	}

	public int getCallingMinutes() {

		return GOLD_CALLING_MINUTES;
	}

}
