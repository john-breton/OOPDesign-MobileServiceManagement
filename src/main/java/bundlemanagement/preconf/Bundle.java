package bundlemanagement.preconf;

public abstract class Bundle {
	
	/**
	 *	Below are components for preconfigured plan.
	 */
	String Name;
	CallingPlan callingplan;
	MessagingPlan messagingplan;
	DataPlan dataplan;
	MonthlyFees monthlyfees;

	/* 
	 * It will be implemented inside PreconfBundle.
	 */
	abstract void prepare();
	
	/**
	 * It will set a name to bundle.
	 * @param Name
	 */

	void setName(String Name) {
		this.Name = Name;
	}
	
	/**
	 * 
	 * @return It will return the name of the bundle.
	 */

	String getName() {
		return Name;
	}
	
	/*
	 * It will print out all bundle information.
	 */

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + Name + " ----\n");
		if (callingplan != null) {
			result.append(callingplan);
			result.append("\n");
		}
		if (messagingplan != null) {
			result.append(messagingplan);
			result.append("\n");
		}
		if (dataplan != null) {
			result.append(dataplan);
			result.append("\n");
		}
		if (monthlyfees != null) {
			result.append(monthlyfees.monthlyfee());
			result.append("$\n");
		}
		if (callingplan != null) {
			if (callingplan.getCallingMinutes() != Integer.MAX_VALUE) {
				result.append("\nCalling time: ");
				result.append(callingplan.getCallingMinutes());
			} else {
				result.append("\nCalling time: ");
				result.append("unlimited");
			}
		}
		if (dataplan != null) {
			result.append("\nData Quantity: ");
			result.append(dataplan.getDataQuantity());
		}
		if (callingplan != null) {
			if (callingplan.getCallingMinutes() != Integer.MAX_VALUE) {
				result.append("\nNumber of messages: ");
				result.append(messagingplan.getNumberOfMessages());
			} else {
				result.append("\nNumber of messages: ");
				result.append("unlimited");
			}
		}

		return result.toString();
	}
}
