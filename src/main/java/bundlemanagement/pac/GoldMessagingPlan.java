package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements gold messaging plan for the PaC Bundle.
 * 
 * @author epahram
 *
 */

public class GoldMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public GoldMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for gold messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHGOLDMESSAGINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for gold messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PACWITHGOLDMESSAGINGPLAN));
	}

	/**
	 * return minutes for gold messaging plan.
	 * 
	 * @return number of messages for gold messaging plan
	 */
	public BigDecimal getNumberOfMessages() {

		return BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PACWITHGOLDMESSAGINGPLAN);
	}

}
