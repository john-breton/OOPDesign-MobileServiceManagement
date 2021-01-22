package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements silver data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class SilverDataPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public SilverDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for silver data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHSILVERDATAPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for silver data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithDataOptionFees.get(BundleNames.PACWITHSILVERDATAPLAN));
	}

	/**
	 * return data quantity for silver data plan.
	 * 
	 * @return data quantity for silver calling plan.
	 */
	public BigDecimal getDataQuantity() {

		return BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PACWITHSILVERDATAPLAN);
	}

}
