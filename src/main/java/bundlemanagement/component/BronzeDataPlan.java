package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements bronze data plan for both PaC , and preconf bundles.
 * 
 * @author epahram
 *
 */

public class BronzeDataPlan extends BundleDecorator implements DataPlan {

	PaCBundle pacbundle;
	private static final int BRONZE_DATA_QUANTITY = 2;
	private static final int BRONZE_DATA_PLAN_FEE = 20;
	private static final String BRONZE_DATA_DESCRIPTION = "Data Plan: Bronze - Data Included: 2 GB";

	/**
	 * Constructor for preconf side
	 */
	public BronzeDataPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle
	 */
	public BronzeDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for bronze data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BRONZE_DATA_DESCRIPTION + "\n";
	}

	/**
	 * sets fee for bronze data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public int cost() {

		return pacbundle.cost() + BRONZE_DATA_PLAN_FEE;
	}

	/**
	 * sets information for bronze data plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "2 GB";
	}

	/**
	 * return minutes for bronze data plan.
	 * 
	 * @return data quantity for Bronze data plan.
	 */
	public int getDataQuantity() {

		return BRONZE_DATA_QUANTITY;
	}

}
