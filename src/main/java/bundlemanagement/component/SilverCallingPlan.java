package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements silver calling plan for the both PaC and preconf bundles.
 * 
 * @author epahram
 *
 */

public class SilverCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int SILVER_CALLING_MINUTES = 100;
	private static final int SILVER_CALLING_PLAN_FEE = 20;
	private static final String SILVER_CALLING_DESCRIPTION = "Calling Plan: Silver - 100 min free Canada wide calling";

	/**
	 * Constructor for preconf side
	 */
	public SilverCallingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public SilverCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for silver calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + SILVER_CALLING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for silver calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + SILVER_CALLING_PLAN_FEE;
	}

	/**
	 * sets information for silver calling plan.
	 * 
	 * return String information to preconf side.
	 */
	public String toString() {
		return "100 min free Canada wide calling";
	}

	/**
	 * Returns calling time for silver calling plan.
	 * 
	 * @return calling time for silver calling plan.
	 */
	public int getCallingMinutes() {

		return SILVER_CALLING_MINUTES;
	}

}
