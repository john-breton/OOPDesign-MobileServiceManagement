package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements bronze messaging plan for both PaC , and preconf
 * bundles.
 * 
 * @author epahram
 *
 */
public class BronzeMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int BRONZE_NUMBER_OF_MESSAGES = 250;
	private static final int BRONZE_NESSAGING_PLAN_FEE = 20;
	private static final String BRONZE_MESSAGING_DESCRIPTION = "Messaging Plan: Bronze - 250 Messages";

	/**
	 * Constructor for preconf side
	 */
	public BronzeMessagingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public BronzeMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for bronze messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BRONZE_MESSAGING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for bronze messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + BRONZE_NESSAGING_PLAN_FEE;
	}

	/**
	 * sets information for bronze messaging plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "250 Messages";
	}

	/**
	 * return minutes for bronze calling plan.
	 * 
	 * @return number of messages for bronze messaging plan.
	 */
	public int getNumberOfMessages() {

		return BRONZE_NUMBER_OF_MESSAGES;
	}

}
