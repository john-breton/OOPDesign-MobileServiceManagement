package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements bronze calling plan for both PaC , and preconf bundles.
 * 
 * @author epahram
 *
 */

public class BronzeCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int BRONZE_CALLING_MINUTES = 30;
	private static final int BRONZE_CALLING_PLAN_FEE = 15;
	private static final String BRONZE_CALLING_DESCRIPTION = "Calling Plan: Bronze - 30 min free Canada wide calling";

	/**
	 * Constructor for preconf side
	 */
	public BronzeCallingPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public BronzeCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for bronze calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {
		return pacbundle.getDescription() + BRONZE_CALLING_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for bronze calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {
		return pacbundle.cost() + BRONZE_CALLING_PLAN_FEE;
	}

	/**
	 * sets information for bronze calling plan.
	 * 
	 * return String information to preconf side.
	 */
	public String toString() {
		return "30 min free Canada wide calling";
	}

	/**
	 * return minutes for bronze calling plan.
	 * 
	 * @return minutes for bronze calling plan.
	 */
	public int getCallingMinutes() {
		return BRONZE_CALLING_MINUTES;
	}

}
