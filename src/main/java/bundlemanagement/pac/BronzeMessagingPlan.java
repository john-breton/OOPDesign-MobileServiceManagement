package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

/**
 * This class implements bronze messaging plan for the PaC Bundle.
 * 
 * @author epahram
 *
 */
public class BronzeMessagingPlan extends BundleDecorator {

	PaCBundle pacbundle;

	/**
	 * Constructor for PaC side
	 * 
	 * @param pacbundle The PaC bundle to be associated with this object
	 */
	public BronzeMessagingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	/**
	 * sets description for bronze messaging plan.
	 * 
	 * @return String it will return plan description to PaC side
	 */
	@Override
	public String getDescription() {

		return pacbundle.getDescription() + BundleNames.PACWITHBRONZEMESSAGINGPLAN.getBundleNames() + "\n";
	}

	/**
	 * sets fee for bronze messaging plan.
	 * 
	 * @return it will return plan's cost to PaC side
	 */
	@Override
	public BigDecimal cost() {

		return pacbundle.cost().add(BundleFees.PaCWithMessagingOptionFees.get(BundleNames.PACWITHBRONZEMESSAGINGPLAN));
	}


	/**
	 * return minutes for bronze messaging plan.
	 * 
	 * @return number of messages for bronze messaging plan.
	 */
	public BigDecimal getNumberOfMessages() {

		return BundleNumericalValues.PaCWithMessagingOptionTotalNumberOfMessages.get(BundleNames.PACWITHBRONZEMESSAGINGPLAN);
	}

}
