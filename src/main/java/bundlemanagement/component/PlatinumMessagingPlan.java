package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class PlatinumMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int PLATINUM_NUMBER_OF_MESSAGES = Integer.MAX_VALUE;
	private static final int PLATINUM_MESSAGING_PLAN_FEE = 45;
	private static final String PLATINUM_MESSAGING_DESCRIPTION = "Platinum: Unlimited Messages";

	public PlatinumMessagingPlan() {
	}

	public PlatinumMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + PLATINUM_MESSAGING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + PLATINUM_MESSAGING_PLAN_FEE;
	}

	public String toString() {
		return "Unlimited Messages";
	}

	public int getNumberOfMessages() {
		// TODO Auto-generated method stub
		return PLATINUM_NUMBER_OF_MESSAGES;
	}

}
