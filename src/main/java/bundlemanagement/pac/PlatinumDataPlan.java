package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements platinum data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class PlatinumDataPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for preconf side
	 */
	public PlatinumDataPlan() {
	}

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public PlatinumDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for platinum data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHPLATINUMDATAPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for platinum data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithDataOptionFees.get(BundleNames.PACWITHPLATINUMDATAPLAN));
	}

	/**
	 * return data quantity for platinum data plan.
	 * 
	 * @return data quantity for platinum plan.
	 */
	public BigDecimal getDataQuantity() {

		return BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PACWITHPLATINUMDATAPLAN);
	}
}
