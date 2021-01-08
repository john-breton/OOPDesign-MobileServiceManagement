package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements silver data plan for theboth PaC and preconf bundles.
 * 
 * @author epahram
 *
 */
public class SilverDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int SILVER_DATA_QUANTITY = 2;
	private static final int SILVER_DATA_PLAN_FEE = 25;
	private static final String SILVER_DATA_DESCRIPTION = "Data Plan: Silver - Data Included: 4 GB";

	/**
	 * Constructor for preconf side
	 */
	public SilverDataPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public SilverDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for silver data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + SILVER_DATA_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for silver data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + SILVER_DATA_PLAN_FEE;
	}

	/**
	 * sets information for silver data plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "2 GB";
	}

	/**
	 * return data quantity for silver data plan.
	 * 
	 * @return data quantity for silver calling plan.
	 */
	public int getDataQuantity() {

		return SILVER_DATA_QUANTITY;
	}

}
