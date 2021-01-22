package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements gold data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class GoldDataPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for gold data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHGOLDDATAPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for gold data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithDataOptionFees.get(BundleNames.PACWITHGOLDDATAPLAN));
	}

	/**
	 * return data for gold data plan.
	 * 
	 * @return data quantity for gold data plan.
	 */
	public BigDecimal getDataQuantity() {

		return BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PACWITHGOLDDATAPLAN);
	}

}
