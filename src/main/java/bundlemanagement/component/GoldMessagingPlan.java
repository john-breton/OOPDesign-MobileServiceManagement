package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class GoldMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int GOLD_NUMBER_OF_MESSAGES = 10000;
	private static final int GOLD_MESSAGING_PLAN_FEE = 35;
	private static final String GOLD_MESSAGING_DESCRIPTION = "Gold: 10k Messages";

	public GoldMessagingPlan() {
	}

	public GoldMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + GOLD_MESSAGING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + GOLD_MESSAGING_PLAN_FEE;
	}

	public String toString() {
		return "10K Messages";
	}

	public int getNumberOfMessages() {
		// TODO Auto-generated method stub
		return GOLD_NUMBER_OF_MESSAGES;
	}

}
