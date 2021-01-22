package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements bronze calling plan for the PaC Bunlde.
 * 
 * @author epahram
 *
 */

public class BronzeCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public BronzeCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for bronze calling plan.
	 * 
	 * @return String it will return plan description to PaC side.
	 */
	@Override
	public String getDescription() {
		return pacbundle.getDescription() + BundleNames.PACWITHBRONZECALLINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for bronze calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */

	@Override
	public BigDecimal cost() {
		return pacbundle.cost().add(BundleFees.PaCWithCallingOptionFees.get(BundleNames.PACWITHBRONZECALLINGPLAN));
	}

	/**
	 * Returns calling time for bronze calling plan.
	 * 
	 * @return calling time for bronze calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PACWITHBRONZECALLINGPLAN);
	}

}
