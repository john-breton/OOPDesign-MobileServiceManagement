package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleNames;

/**
 * This class implements the empty calling plan. It is used when customer did not choose
 * calling plan for pac bundle
 * @author enuyhza
 */
public class EmptyCallingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal emptyCallingMinutes;
	private final String description;
	

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public EmptyCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.emptyCallingMinutes = BundleNumericalValues.PaCWithCallingOptionTotalMinutes.get(BundleNames.PAC_WITH_OUT_CALLING_PLAN);
		this.description = BundleNames.PAC_WITH_OUT_CALLING_PLAN.getBundleDescription();
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
	 * sets fee for empty calling plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost();
	}
	
	/**
	 * Returns calling time for empty calling plan.
	 * 
	 * @return calling time for empty calling plan.
	 */
	public BigDecimal getCallingMinutes() {

		return emptyCallingMinutes;
	}
}
