package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements Zero calling plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroCallingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;
	private final BigDecimal zeroCallingFee;
	private final BigDecimal zeroCallingMinutes;
	private final String description;

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.zeroCallingFee = BundleFees.PaCWithCallingOptionFees.get(BundleNames.PAC_WITH_ZERO_CALLING_PLAN);
		this.zeroCallingMinutes = BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PAC_WITH_ZERO_CALLING_PLAN);
		this.description = BundleNames.PAC_WITH_ZERO_CALLING_PLAN.getBundleDescription();
	}

	/**
	 * Sets description for zero calling plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * Sets fee for zero calling plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(zeroCallingFee);
	}

	/**
	 * Sets minutes for PaC bundle.
	 * 
	 * @return calling minutes time to PaC bundle.
	 */
	public BigDecimal getCallingMinutes() {

		return zeroCallingMinutes;
	}

}
