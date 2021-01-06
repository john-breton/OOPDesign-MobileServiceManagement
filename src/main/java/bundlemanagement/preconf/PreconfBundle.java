package bundlemanagement.preconf;

import bundlemanagement.service.Bundle;

public class PreconfBundle extends Bundle {
	CallingPlan callingplan;
	MessagingPlan messagingplan;
	DataPlan dataplan;
	MonthlyFees monthlyfees;
	BundleComponentFactory ComponentFactory;

	/**
	 * The constructor will set the value for related BundleComponentFactory.
	 * 
	 * @param ComponentFactory
	 */

	public PreconfBundle(BundleComponentFactory ComponentFactory) {
		this.ComponentFactory = ComponentFactory;
	}

	/**
	 * It will prepare prepare component for it's related bundle plan through
	 * calling proper BundleComponentFactory
	 */
	void prepare() {
		//System.out.println("Preparing " + getName());
		callingplan = ComponentFactory.createCallingPlan();
		messagingplan = ComponentFactory.createMessagingPlan();
		dataplan = ComponentFactory.createDataPaln();
		monthlyfees = ComponentFactory.createMonthlyFees();
	}
	public String toString() {
		StringBuffer result = new StringBuffer();
		//result.append("------ " + getName() + " ------\n");
		if (callingplan != null) {
			result.append("Calling Plan: ");
			result.append(callingplan);
			result.append("\n");
		}
		if (messagingplan != null) {
			result.append("Messaging Plan: ");
			result.append(messagingplan);
			result.append("\n");
		}
		if (dataplan != null) {
			result.append("Data Plan: ");
			result.append(dataplan);
			result.append("\n");
		}
		if (monthlyfees != null) {
			result.append("Monthly Fee: $");
			result.append("\n");
			result.append(monthlyfees.monthlyfee());
			
		}
		/*
		if (callingplan != null) {
			if (callingplan.getCallingMinutes() != Integer.MAX_VALUE) {
				result.append("\nCalling time: ");
				result.append(callingplan.getCallingMinutes());
			} else {
				result.append("\nCalling time: ");
				result.append("unlimited");
			}
		}

		if (messagingplan != null) {
			if (messagingplan.getNumberOfMessages() != Integer.MAX_VALUE) {
				result.append("\nNumber of messages: ");
				result.append(messagingplan.getNumberOfMessages());
			} else {
				result.append("\nNumber of messages: ");
				result.append("unlimited");
			}
		}
		if (dataplan != null) {
			result.append("\nData Quantity: ");
			result.append(dataplan.getDataQuantity());
		}*/

		return result.toString();
	}
}
