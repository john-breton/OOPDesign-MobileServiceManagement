package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements silver data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class SilverDataPlan extends BundleDecorator {

	PaCBundle pacbundle;	
	private final BigDecimal silverDataFee;
	private final BigDecimal silverDataQuant;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public SilverDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.silverDataFee = BundleFees.PaCWithDataOptionFees.get(BundleNames.PAC_WITH_SILVER_DATA_PLAN);
		this.silverDataQuant = BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PAC_WITH_SILVER_DATA_PLAN);
		this.description = BundleNames.PAC_WITH_SILVER_DATA_PLAN.getBundleDescription();
	}

	/**
	 * sets description for silver data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for silver data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(silverDataFee);
	}

	/**
	 * return data quantity for silver data plan.
	 * 
	 * @return data quantity for silver calling plan.
	 */
	public BigDecimal getDataQuantity() {

		return silverDataQuant;
	}

}
