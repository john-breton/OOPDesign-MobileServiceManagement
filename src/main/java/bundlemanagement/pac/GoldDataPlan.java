package bundlemanagement.pac;

import java.math.BigDecimal;
import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements gold data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class GoldDataPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal goldDataFee;
	private final BigDecimal goldDataQuant;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.goldDataFee = BundleFees.PaCWithDataOptionFees.get(BundleNames.PAC_WITH_GOLD_DATA_PLAN);
		this.goldDataQuant = BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PAC_WITH_GOLD_DATA_PLAN);
		this.description = BundleNames.PAC_WITH_GOLD_DATA_PLAN.getBundleDescription();
	}

	/**
	 * sets description for gold data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for gold data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(goldDataFee);
	}

	/**
	 * return data for gold data plan.
	 * 
	 * @return data quantity for gold data plan.
	 */
	public BigDecimal getDataQuantity() {

		return goldDataQuant;
	}

}
