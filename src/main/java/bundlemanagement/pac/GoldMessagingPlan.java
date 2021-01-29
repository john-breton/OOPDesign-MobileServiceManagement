package bundlemanagement.pac;

import java.math.BigDecimal;
import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements gold messaging plan for the PaC Bundle.
 * 
 * @author epahram
 *
 */

public class GoldMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal goldMessagingFee;
	private final BigDecimal goldMessagingNums;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.goldMessagingFee = BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PAC_WITH_GOLD_MESSAGING_PLAN);
		this.goldMessagingNums = BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PAC_WITH_GOLD_MESSAGING_PLAN);
	}

	/**
	 * sets description for gold messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PAC_WITH_GOLD_MESSAGING_PLAN.getBundleDescription() + "\n";
	}

	/**
	 * sets fee for gold messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(goldMessagingFee);
	}

	/**
	 * return minutes for gold messaging plan.
	 * 
	 * @return number of messages for gold messaging plan
	 */
	public BigDecimal getNumberOfMessages() {

		return goldMessagingNums;
	}

}
