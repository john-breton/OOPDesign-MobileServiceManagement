package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements Zero data plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroDataPlan extends BundleDecorator {

	final PaCBundle pacbundle;
	private final BigDecimal zeroDataFee;
	private final BigDecimal zeroDataQuant;
	private final String description;

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.zeroDataFee = BundleFees.PaCWithDataOptionFees.get(BundleNames.PAC_WITH_ZERO_DATA_PLAN);
		this.zeroDataQuant = BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PAC_WITH_ZERO_DATA_PLAN);
		this.description = BundleNames.PAC_WITH_ZERO_DATA_PLAN.getBundleDescription();
	}

	/**
	 * Sets description for zero data plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * Sets fee for zero data plan.
	 * 
	 * @return cost integer value to PaC side.
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(zeroDataFee);
	}

	/**
	 * Sets data quantity for zero data plan.
	 * 
	 * @return data quantity to PaC bundle.
	 */
	public BigDecimal getDataQuantity() {

		return zeroDataQuant;
	}

}
