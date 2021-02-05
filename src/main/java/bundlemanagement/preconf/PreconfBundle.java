package bundlemanagement.preconf;

import java.math.BigDecimal;

import bundlemanagement.service.Bundle;

/**
 * This class gets call BundleShop and SimplePreconfBundleFactory to create all
 * component for related plans.
 * 
 * Different bundle shop(bronze, platinum, silver, and platinum) asks this class
 * to create calling plan, messaging plan, data plan, and monthly fee for them.
 * 
 * @author enuyhza
 * @author epahram
 *
 */
public class PreconfBundle extends Bundle {
	/**
	 * This attribute could go to Bundle class as well, so this way you don't need
	 * to use simple factory on top(Ista's comment).
	 */
	CallingPlanOptions callingplan;
	MessagingPlanOptions messagingplan;
	DataPlanOptions dataplan;
	BigDecimal monthlyfees;
	BundleComponentFactory ComponentFactory;

	/**
	 * The constructor will set the value for related BundleComponentFactory.
	 * 
	 * @param ComponentFactory The BundleComponentFactory associated with this
	 *                         Object
	 */

	public PreconfBundle(BundleComponentFactory ComponentFactory) {
		this.ComponentFactory = ComponentFactory;
	}

	/**
	 * Get monthly fee for Preconfigured Bundle
	 * 
	 * @return Monthly fee of this Preconfigured Bundle
	 */
	public BigDecimal cost() {
		return monthlyfees;
	}

	/**
	 * It will prepare component for it's related bundle plan through calling proper
	 * BundleComponentFactory. It can be PlatinumBundleComponentFactory, or ...
	 */
	void prepare() {
		setName(ComponentFactory.createBundleNames());
		callingplan = ComponentFactory.createCallingPlan();
		messagingplan = ComponentFactory.createMessagingPlan();
		dataplan = ComponentFactory.createDataPlan();
		monthlyfees = ComponentFactory.createMonthlyFees();
	}

	/**
	 * Generate bundle detail for bundle.
	 * 
	 * @return String contains bundle detail for this bundle
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		if (callingplan != null) {
			result.append("Calling Plan: ");
			result.append(callingplan.getCallingPlanOptionsDesription());
			result.append("\n");
		}
		if (messagingplan != null) {
			result.append("Messaging Plan: ");
			result.append(messagingplan.getdMessagingPlanOptionsDesription());
			result.append("\n");
		}
		if (dataplan != null) {
			result.append("Data Plan: ");
			result.append(dataplan.getdDataPlanOptionsDesription());
			result.append("\n");
		}
		if (monthlyfees != null) {
			result.append("Monthly Fee: $");
			result.append(monthlyfees);
			result.append("\n");

		}

		return result.toString();
	}
}
