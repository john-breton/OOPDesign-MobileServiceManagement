package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements platinum data plan for the both PaC and preconf bundles.
 * 
 * @author epahram
 *
 */
public class PlatinumDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int PLATINUM_DATA_QUANTITY = 10;
	private static final int PLATINUM_DATA_PLAN_FEE = 40;
	private static final String PLATINUM_DATA_DESCRIPTION = "Data Plan: Platinum - Data Included: 10 GB";

	/**
	 * Constructor for preconf side
	 */
	public PlatinumDataPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public PlatinumDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for platinum data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + PLATINUM_DATA_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for platinum data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + PLATINUM_DATA_PLAN_FEE;
	}

	/**
	 * sets information for platinum data plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "10 GB";
	}

	/**
	 * return data quantity for platinum data plan.
	 * 
	 * @return data quantity for platinum plan.
	 */
	public int getDataQuantity() {

		return PLATINUM_DATA_QUANTITY;
	}
}
