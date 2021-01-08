package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements gold calling plan for the both PaC and preconf bundles.
 * 
 * @author epahram
 *
 */
public class GoldCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int GOLD_CALLING_MINUTES = Integer.MAX_VALUE;
	private static final int GOLD_CALLING_PLAN_FEE = 30;
	private static final String GOLD_CALLING_DESCRIPTION = "Calling Plan: Gold - Unlimited Canada wide calling";

	/**
	 * Constructor for preconf side
	 */
	public GoldCallingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public GoldCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for gold calling plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + GOLD_CALLING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for gold calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + GOLD_CALLING_PLAN_FEE;
	}

	/**
	 * sets information for gold calling plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "Unlimited Canada wide calling";
	}

	/**
	 * Returns calling time for gold calling plan.
	 * 
	 * @return calling time for gold calling plan.
	 */
	public int getCallingMinutes() {

		return GOLD_CALLING_MINUTES;
	}

}
