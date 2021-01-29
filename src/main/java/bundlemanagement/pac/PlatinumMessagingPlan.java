package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements platinum messaging plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class PlatinumMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal platinumMessagingFee;
	private final BigDecimal platinumMessagingNums;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public PlatinumMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.platinumMessagingFee = BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PAC_WITH_PLATINUM_MESSAGING_PLAN);
		this.platinumMessagingNums = BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PAC_WITH_PLATINUM_MESSAGING_PLAN);
		this.description = BundleNames.PAC_WITH_PLATINUM_MESSAGING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for platinum messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for platinum messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(platinumMessagingFee);
	}

	/**
	 * sets information for platinum messaging plan.
	 * 
	 * @return String information to preconf side.
	 */
	public String toString() {
		return "Unlimited Messages";
	}

	/**
	 * return number of messages for platinum messaging plan.
	 * 
	 * @return value of number of messages for platinum plan.
	 */
	public BigDecimal getNumberOfMessages() {

		return platinumMessagingNums;
	}

}
