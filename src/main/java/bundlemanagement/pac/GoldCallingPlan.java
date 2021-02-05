package bundlemanagement.pac;

import java.math.BigDecimal;
import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements gold calling plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class GoldCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal goldCallingFee;
	private final BigDecimal goldCallingMinutes;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.goldCallingFee = BundleFees.PaCWithCallingOptionFees.get(BundleNames.PAC_WITH_GOLD_CALLING_PLAN);
		this.goldCallingMinutes = BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PAC_WITH_GOLD_CALLING_PLAN);
		this.description = BundleNames.PAC_WITH_GOLD_CALLING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for gold calling plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for gold calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(goldCallingFee);
	}

	/**
	 * Returns calling time for gold calling plan.
	 * 
	 * @return calling time for gold calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return goldCallingMinutes;
	}

}
