package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements silver messaging plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class SilverMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle that will be associated with this Object
	 */
	public SilverMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for silver messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHSILVERMESSAGINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for silver messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PACWITHSILVERMESSAGINGPLAN));
	}

	/**
	 * return number of messages for silver messaging plan.
	 * 
	 * @return number of messages for silver messaging plan
	 */
	public BigDecimal getNumberOfMessages() {

		return BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PACWITHSILVERMESSAGINGPLAN);
	}

}
