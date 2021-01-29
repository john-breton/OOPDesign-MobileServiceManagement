package bundlemanagement.pac;

import java.math.BigDecimal;
import bundlemanagement.service.BundleFees;
import bundlemanagement.service.BundleNames;

/**
 * This class implements bronze messaging plan for the PaC Bundle.
 * 
 * @author epahram
 *
 */
public class BronzeMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;
	private final BigDecimal bronzeMessagingFee;
	private final BigDecimal bronzeMessagingNums;
	private final String description;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public BronzeMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
		this.bronzeMessagingFee = BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PAC_WITH_BRONZE_MESSAGING_PLAN);
		this.bronzeMessagingNums = BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages.get(BundleNames.PAC_WITH_BRONZE_MESSAGING_PLAN);
		this.description = BundleNames.PAC_WITH_BRONZE_MESSAGING_PLAN.getBundleDescription();
	}

	/**
	 * sets description for bronze messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + description + "\n";
	}

	/**
	 * sets fee for bronze messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(bronzeMessagingFee);
	}


	/**
	 * return minutes for bronze messaging plan.
	 * 
	 * @return number of messages for bronze messaging plan.
	 */
	public BigDecimal getNumberOfMessages() {

		return bronzeMessagingNums;
	}

}
