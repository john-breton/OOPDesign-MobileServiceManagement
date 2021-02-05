package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements silver messaging plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class SilverMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal silverMessagingFee;
	private final BigDecimal silverMessagingNums;
	private final String description;


	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle that will be associated with this Object
	 */
	public SilverMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.silverMessagingFee = BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PAC_WITH_SILVER_MESSAGING_PLAN);
		this.silverMessagingNums = BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PAC_WITH_SILVER_MESSAGING_PLAN);
		this.description = BundleNames.PAC_WITH_SILVER_MESSAGING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for silver messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for silver messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(silverMessagingFee);
	}

	/**
	 * return number of messages for silver messaging plan.
	 * 
	 * @return number of messages for silver messaging plan
	 */
	public BigDecimal getNumberOfMessages() {

		return silverMessagingNums;
	}

}
