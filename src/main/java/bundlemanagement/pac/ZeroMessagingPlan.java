package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.preconf.BundleFees;
import bundlemanagement.preconf.BundleNames;

/**
 * This class implements Zero messaging plan for PaC bundle.
 * 
 * @author epahram
 *
 */
public class ZeroMessagingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;

	/**
	 * Setup constructor
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public ZeroMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * 
	 * Sets description for zero messaging plan.
	 * 
	 * @return description to PaC side.
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHZEROMESSAGINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * Sets fee for zero messaging plan.
	 * 
	 * @return cost value to PaC side.
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PACWITHZEROMESSAGINGPLAN));
	}

	/**
	 * return number of messages for zero messaging plan.
	 * 
	 * @return number of messages to PaC bundle.
	 */
	public BigDecimal getNumberOfMessages() {

		return BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages.get(BundleNames.PACWITHZEROMESSAGINGPLAN);
	}

}
