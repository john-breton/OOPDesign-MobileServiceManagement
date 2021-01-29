package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements platinum data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class PlatinumDataPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal platinumDataFee;
	private final BigDecimal platinumDataQuant;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public PlatinumDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.platinumDataFee = BundleFees.PaCWithDataOptionFees.get(BundleNames.PAC_WITH_PLATINUM_DATA_PLAN);
		this.platinumDataQuant = BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PAC_WITH_PLATINUM_DATA_PLAN);
		this.description = BundleNames.PAC_WITH_PLATINUM_DATA_PLAN.getBundleDescription();
	}

	/**
	 * sets description for platinum data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for platinum data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(platinumDataFee);
	}

	/**
	 * return data quantity for platinum data plan.
	 * 
	 * @return data quantity for platinum plan.
	 */
	public BigDecimal getDataQuantity() {

		return platinumDataQuant;
	}
}
