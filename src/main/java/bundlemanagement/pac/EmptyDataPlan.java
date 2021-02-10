package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleNames;

/**
 * This class implements the empty data plan. It is used when customer did not choose
 * data plan for pac bundle
 * @author enuyhza
 */
public class EmptyDataPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal emptyDataQuant;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public EmptyDataPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.emptyDataQuant = BundleNumericalValues.PaCWithDataOptionDataQuantity.get(BundleNames.PAC_WITH_OUT_DATA_PLAN);
		this.description = BundleNames.PAC_WITH_OUT_DATA_PLAN.getBundleDescription();
	}

	/**
	 * sets description for empty calling plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for empty data plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost();
	}
	/**
	 * return data for empty data plan.
	 * 
	 * @return data quantity for empty data plan.
	 */
	public BigDecimal getDataQuantity() {

		return emptyDataQuant;
	}
}
