package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleNames;

/**
 * This class implements the empty messaging plan. It is used when customer did not choose
 * messaging plan for pac bundle
 * @author enuyhza
 */
public class EmptyMessagingPlan extends BundleDecorator {
	PaCBundle pacbundle;
	private final BigDecimal emptyMessagingNums;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public EmptyMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.emptyMessagingNums = BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PAC_WITH_OUT_MESSAGING_PLAN);
		this.description = BundleNames.PAC_WITH_OUT_MESSAGING_PLAN.getBundleDescription();
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
	 * return fees for empty messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost();
	}
	
	/**
	 * return number of messages for empty messaging plan.
	 * 
	 * @return number of messages to PaC bundle.
	 */
	public BigDecimal getNumberOfMessages() {

		return emptyMessagingNums;
	}

}
