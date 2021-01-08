package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements gold data plan for the both PaC and preconf bundles.
 * 
 * @author epahram
 *
 */
public class GoldDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int GOLD_DATA_QUANTITY = 4;
	private static final int GOLD_DATA_PLAN_FEE = 30;
	private static final String GOLD_DATA_DESCRIPTION = "Data Plan: Gold - Data Included: 7 GB";

	/**
	 * Constructor for preconf side
	 */
	public GoldDataPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public GoldDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for gold data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + GOLD_DATA_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for gold data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + GOLD_DATA_PLAN_FEE;
	}

	/**
	 * sets information for gold data plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "4 GB";
	}

	/**
	 * return minutes for gold data plan.
	 * 
	 * @return data quantity for gold data plan.
	 */
	public int getDataQuantity() {

		return GOLD_DATA_QUANTITY;
	}

}
