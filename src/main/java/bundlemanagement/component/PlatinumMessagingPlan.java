package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements platinum messaging plan for the both PaC and preconf
 * bundles.
 * 
 * @author epahram
 *
 */
public class PlatinumMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int PLATINUM_NUMBER_OF_MESSAGES = Integer.MAX_VALUE;
	private static final int PLATINUM_MESSAGING_PLAN_FEE = 45;
	private static final String PLATINUM_MESSAGING_DESCRIPTION = "Messaging Plan: Platinum - Unlimited Messages";

	/**
	 * Constructor for preconf side
	 */
	public PlatinumMessagingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public PlatinumMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for platinum messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + PLATINUM_MESSAGING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for platinum messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + PLATINUM_MESSAGING_PLAN_FEE;
	}

	/**
	 * sets information for platinum messaging plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "Unlimited Messages";
	}

	/**
	 * return number of messages for platinum messaging plan.
	 * 
	 * @return int value of number of messages for platinum plan.
	 */
	public int getNumberOfMessages() {

		return PLATINUM_NUMBER_OF_MESSAGES;
	}

}
