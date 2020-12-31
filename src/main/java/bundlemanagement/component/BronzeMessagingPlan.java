package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BronzeMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int BRONZE_NUMBER_OF_MESSAGES = 250;
	private static final int BRONZE_NESSAGING_PLAN_FEE = 20;
	private static final String BRONZE_MESSAGING_DESCRIPTION = "Bronze: 250 Messages";

	public BronzeMessagingPlan() {
	}

	public BronzeMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + BRONZE_MESSAGING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + BRONZE_NESSAGING_PLAN_FEE;
	}

	public String toString() {
		return "250 Messages";
	}

	public int getNumberOfMessages() {
		// TODO Auto-generated method stub
		return BRONZE_NUMBER_OF_MESSAGES;
	}

}
