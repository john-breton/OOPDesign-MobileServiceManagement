package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.preconf.*;
import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements bronze calling plan for the PaC Bunlde.
 * 
 * @author epahram
 *
 */

public class BronzeCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal bronzeCallingFee;
	private final BigDecimal bronzeCallingMinuetes;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public BronzeCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.bronzeCallingFee = BundleFees.PaCWithCallingOptionFees.get(BundleNames.PAC_WITH_BRONZE_CALLING_PLAN);
		this.bronzeCallingMinuetes = BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PAC_WITH_BRONZE_CALLING_PLAN);
		this.description = BundleNames.PAC_WITH_BRONZE_CALLING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for bronze calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {
		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for bronze calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */

	@Override
	public BigDecimal cost() {
		return pacbundle.cost().add(bronzeCallingFee);
	}

	/**
	 * Returns calling time for bronze calling plan.
	 * 
	 * @return calling time for bronze calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return bronzeCallingMinuetes;
	}

}
