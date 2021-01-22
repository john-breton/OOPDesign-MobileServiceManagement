package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements gold calling plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class GoldCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for gold calling plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHGOLDCALLINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for gold calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithCallingOptionFees.get(BundleNames.PACWITHGOLDCALLINGPLAN));
	}

	/**
	 * Returns calling time for gold calling plan.
	 * 
	 * @return calling time for gold calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PACWITHGOLDCALLINGPLAN);
	}

}
