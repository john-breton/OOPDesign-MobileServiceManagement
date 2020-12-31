package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class PlatinumCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int PLATINUM_CALLING_MINUTES = Integer.MAX_VALUE;
	private static final int PLATINUM_CALLING_PLAN_FEE = 40;
	private static final String PLATINUM_CALLING_DESCRIPTION = "Platinum: Unlimited US & Canada wide calling";

	public PlatinumCallingPlan() {
	}

	public PlatinumCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + PLATINUM_CALLING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + PLATINUM_CALLING_PLAN_FEE;
	}

	public String toString() {
		return "Unlimited US & Canada wide calling";
	}

	public int getCallingMinutes() {
		// TODO Auto-generated method stub
		return PLATINUM_CALLING_MINUTES;
	}

}
