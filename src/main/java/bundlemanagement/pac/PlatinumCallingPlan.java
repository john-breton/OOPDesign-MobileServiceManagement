package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements platinum calling plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class PlatinumCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal platinumCallingFee;
	private final BigDecimal platinumCallingMinutes;
	private final String description;

	/**
	 * constructor for PaC side.
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public PlatinumCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.platinumCallingFee = BundleFees.PaCWithCallingOptionFees.get(BundleNames.PAC_WITH_PLATINUM_CALLING_PLAN);
		this.platinumCallingMinutes = BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PAC_WITH_PLATINUM_CALLING_PLAN);
		this.description = BundleNames.PAC_WITH_PLATINUM_CALLING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for platinum calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for platinum calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */

	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(platinumCallingFee);
	}

	/**
	 * Returns calling time for platinum calling plan.
	 * 
	 * @return calling time for platinum calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return platinumCallingMinutes;
	}

}
