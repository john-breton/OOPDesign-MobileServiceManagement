package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

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
	 * It will assign description to PaC.
	 * 
	 * @return PLATINUM_CALLING_DESCRIPTION
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + PLATINUM_CALLING_DESCRIPTION + "\n";
	}

	/**
	 * It will use for PaC side.
	 * 
	 * @return cost for Platinum Calling plan
	 */

	@Override
	public int cost() {

		return pacbundle.cost() + PLATINUM_CALLING_PLAN_FEE;
	}

	/**
	 * It will use for preconf side.
	 * 
	 * @return information about platinum preconf bundle.
	 */

	public String toString() {
		return "Unlimited US & Canada wide calling";
	}

	/**
	 * It will return CallingMinutes to preconf side.
	 * 
	 * @return platinum calling minutes
	 */
	public int getCallingMinutes() {

		return PLATINUM_CALLING_MINUTES;
	}

}
