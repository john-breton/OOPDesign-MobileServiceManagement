package bundlemanagement.pac;

import java.math.BigDecimal;
import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements bronze data plan for the PaC bundle.
 * 
 * @author epahram
 *
 */

public class BronzeDataPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal bronzeDataFee;
	private final BigDecimal bronzeDataQuant;
	private final String description;
	

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public BronzeDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.bronzeDataFee = BundleFees.PaCWithDataOptionFees.get(BundleNames.PAC_WITH_BRONZE_DATA_PLAN);
		this.bronzeDataQuant = BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PAC_WITH_BRONZE_DATA_PLAN);
		this.description = BundleNames.PAC_WITH_BRONZE_DATA_PLAN.getBundleDescription();
	}

	/**
	 * sets description for bronze data plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for bronze data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(bronzeDataFee);
	}

	/**
	 * return data for bronze data plan.
	 * 
	 * @return data quantity for Bronze data plan.
	 */
	public BigDecimal getDataQuantity() {

		return bronzeDataQuant;
	}
}
