package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements silver messaging plan for both the PaC and preconf
 * bundles.
 * 
 * @author epahram
 *
 */
public class SilverMessagingPlan extends BundleDecorator implements MessagingPlan {

	PaCBundle pacbundle;
	private static final int SILVER_NUMBER_OF_MESSAGES = 5000;
	private static final int SILVER_MESSAGING_PLAN_FEE = 25;
	private static final String SILVER_MESSAGING_DESCRIPTION = "Messaging Plan: Silver - 5K Messages";

	/**
	 * Constructor for preconf side
	 */
	public SilverMessagingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle that will be associated with this Object
	 */
	public SilverMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for silver messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + SILVER_MESSAGING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for silver messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + SILVER_MESSAGING_PLAN_FEE;
	}

	/**
	 * sets information for silver messaging plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "5K Messages";
	}

	/**
	 * @return number of messages for silver messaging plan
	 */
	public int getNumberOfMessages() {

		return SILVER_NUMBER_OF_MESSAGES;
	}

}
