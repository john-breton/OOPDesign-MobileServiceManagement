package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements Zero messaging plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroMessagingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;
	private final BigDecimal zeroMessagingFee;
	private final BigDecimal zeroMessagingNums;
	private final String description;

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.zeroMessagingFee = BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PAC_WITH_OUT_MESSAGING_PLAN);
		this.zeroMessagingNums = BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages.get(BundleNames.PAC_WITH_OUT_MESSAGING_PLAN);
		this.description = BundleNames.PAC_WITH_OUT_MESSAGING_PLAN.getBundleDescription();
	}

	/**
	 * 
	 * Sets description for zero messaging plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * Sets fee for zero messaging plan.
	 * 
	 * @return cost value to PaC side.
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(zeroMessagingFee);
	}

	/**
	 * return number of messages for zero messaging plan.
	 * 
	 * @return number of messages to PaC bundle.
	 */
	public BigDecimal getNumberOfMessages() {

		return zeroMessagingNums;
	}

}
