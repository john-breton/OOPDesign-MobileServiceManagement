package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements bronze data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */

public class BronzeDataPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public BronzeDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for bronze data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHBRONZEDATAPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for bronze data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithDataOptionFees.get(BundleNames.PACWITHBRONZEDATAPLAN));
	}

	/**
	 * return data for bronze data plan.
	 * 
	 * @return data quantity for Bronze data plan.
	 */
	public BigDecimal getDataQuantity() {

		return BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PACWITHBRONZEDATAPLAN);
	}
}
