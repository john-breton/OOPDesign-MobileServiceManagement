package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.preconf.BundleFees;
import bundlemanagement.preconf.BundleNames;

/**
 * This class implements Zero data plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroDataPlan extends BundleDecorator {

	final PaCBundle pacbundle;

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * Sets description for zero data plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHZERODATAPLAN.getBundleNames() + "\n";
	}

	/**
	 * Sets fee for zero data plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithDataOptionFees.get(BundleNames.PACWITHZERODATAPLAN));
	}

	/**
	 * Sets data quantity for zero data plan.
	 * 
	 * @return data quantity to PaC bundle.
	 */
	public BigDecimal getDataQuantity() {

		return BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PACWITHZERODATAPLAN);
	}

}
