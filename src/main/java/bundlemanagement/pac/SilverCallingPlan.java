package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements silver calling plan for the PaC bundle.
 * 
 * @author epahram
 *
 */

public class SilverCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal silverCallingFee;
	private final BigDecimal silverCallingMinuetes;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public SilverCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.silverCallingFee = BundleFees.PaCWithCallingOptionFees.get(BundleNames.PAC_WITH_SILVER_CALLING_PLAN);
		this.silverCallingMinuetes = BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PAC_WITH_SILVER_CALLING_PLAN);
		this.description = BundleNames.PAC_WITH_SILVER_CALLING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for silver calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for silver calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(silverCallingFee);
	}

	/**
	 * Returns calling time for silver calling plan.
	 * 
	 * @return calling time for silver calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return silverCallingMinuetes;
	}

}
