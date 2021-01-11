package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements gold messaging plan for the both PaC and preconf bundles.
 * 
 * @author epahram
 *
 */

public class GoldMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int GOLD_NUMBER_OF_MESSAGES = 10000;
	private static final int GOLD_MESSAGING_PLAN_FEE = 35;
	private static final String GOLD_MESSAGING_DESCRIPTION = "Messaging Plan: Gold - 10k Messages";

	/**
	 * Constructor for preconf side
	 */
	public GoldMessagingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for gold messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + GOLD_MESSAGING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for gold messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + GOLD_MESSAGING_PLAN_FEE;
	}

	/**
	 * sets information for gold messaging plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "10K Messages";
	}

	/**
	 * return minutes for gold messaging plan.
	 * 
	 * @return number of messages for gold messaging plan
	 */
	public int getNumberOfMessages() {

		return GOLD_NUMBER_OF_MESSAGES;
	}

}
