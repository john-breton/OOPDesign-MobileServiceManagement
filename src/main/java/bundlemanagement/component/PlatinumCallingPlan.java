package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements platinum calling plan for both PaC , and preconf
 * bundles.
 * 
 * @author epahram
 *
 */
public class PlatinumCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	/**
	 * PLATINUM_CALLING_MINUTES assigned MAX_VALUE as it's unlimited
	 */
	private static final int PLATINUM_CALLING_MINUTES = Integer.MAX_VALUE;
	private static final int PLATINUM_CALLING_PLAN_FEE = 40;
	private static final String PLATINUM_CALLING_DESCRIPTION = "Calling Plan: Platinum - Unlimited US & Canada wide calling";

	/**
	 * constructor for preconf side.
	 */
	public PlatinumCallingPlan() {
	}

	/**
	 * constructor for PaC side.
	 * 
	 * @param pacbundle
	 */
	public PlatinumCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for platinum calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + PLATINUM_CALLING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for platinum calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */

	@Override
	public int cost() {

		return pacbundle.cost() + PLATINUM_CALLING_PLAN_FEE;
	}

	/**
	 * sets information for platinum calling plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "Unlimited US & Canada wide calling";
	}

	/**
	 * return minutes for platinum calling plan.
	 * 
	 * @return int value of plan cost.
	 */
	public int getCallingMinutes() {

		return PLATINUM_CALLING_MINUTES;
	}

}
