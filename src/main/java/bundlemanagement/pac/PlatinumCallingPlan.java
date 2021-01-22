package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements platinum calling plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class PlatinumCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * constructor for PaC side.
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public PlatinumCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for platinum calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHPLATINUMCALLINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for platinum calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */

	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithCallingOptionFees.get(BundleNames.PACWITHPLATINUMCALLINGPLAN));
	}

	/**
	 * Returns calling time for platinum calling plan.
	 * 
	 * @return calling time for platinum calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PACWITHPLATINUMCALLINGPLAN);
	}

}
