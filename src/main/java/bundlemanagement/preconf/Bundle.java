package bundlemanagement.preconf;

public abstract class Bundle {
	String Name;
	CallingPlan callingplan;
	MessagingPlan messagingplan;
	DataPlan dataplan;
	MonthlyFees monthlyfees;
	
	//it will call ComponenetBundleFactory
	abstract void prepare();
	
	void setName(String Name) 
	{
		this.Name=Name;
	}
	
	String getName() 
	{
		return Name;
	}
	
	public String toString() 
	{
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
			result.append(monthlyfees);
			result.append("\n");
		}
		return result.toString();
	}
}
