package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class SilverMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int SILVER_NUMBER_OF_MESSAGES = 5000;
	private static final int SILVER_MESSAGING_PLAN_FEE = 25;
	private static final String SILVER_MESSAGING_DESCRIPTION = "Silver: 5K Messages";

	public SilverMessagingPlan() {
	}

	public SilverMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {

		return pacbundle.getDescription() + SILVER_MESSAGING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {

		return pacbundle.cost() + SILVER_MESSAGING_PLAN_FEE;
	}

	public String toString() {
		return "5K Messages";
	}

	public int getNumberOfMessages() {

		return SILVER_NUMBER_OF_MESSAGES;
	}

}
