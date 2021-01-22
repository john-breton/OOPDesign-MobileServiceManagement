package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements silver calling plan for the PaC bundle.
 * 
 * @author epahram
 *
 */

public class SilverCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public SilverCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for silver calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHSILVERCALLINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for silver calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithCallingOptionFees.get(BundleNames.PACWITHSILVERCALLINGPLAN));
	}

	/**
	 * Returns calling time for silver calling plan.
	 * 
	 * @return calling time for silver calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PACWITHSILVERCALLINGPLAN);
	}

}
