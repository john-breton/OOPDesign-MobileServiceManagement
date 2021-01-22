package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements platinum messaging plan for the PaC bundle.
 * 
 * @author epahram
 *
 */
public class PlatinumMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public PlatinumMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for platinum messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHPLATINUMMESSAGINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for platinum messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost()
				.add(BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PACWITHPLATINUMMESSAGINGPLAN));
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

		return BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages
				.get(BundleNames.PACWITHPLATINUMMESSAGINGPLAN);
	}

}
