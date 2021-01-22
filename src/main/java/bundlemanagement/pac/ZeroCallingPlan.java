package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.preconf.BundleFees;
import bundlemanagement.preconf.BundleNames;

/**
 * This class implements Zero calling plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroCallingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * Sets description for zero calling plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHZEROCALLINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * Sets fee for zero calling plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithCallingOptionFees.get(BundleNames.PACWITHZEROCALLINGPLAN));
	}

	/**
	 * Sets minutes for PaC bundle.
	 * 
	 * @return calling minutes time to PaC bundle.
	 */
	public BigDecimal getCallingMinutes() {

		return BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PACWITHZEROCALLINGPLAN);
	}

}
