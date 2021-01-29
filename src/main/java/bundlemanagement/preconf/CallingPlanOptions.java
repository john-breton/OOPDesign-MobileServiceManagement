package bundlemanagement.preconf;


public enum CallingPlanOptions {
	
	/**
	 * Calling Plan Options
	 */
	PLATINUM("Platinum Calling Plan", "Unlimited US & Canada wide calling"),
	GOLD("Gold Calling Plan", "Unlimited Canada wide calling"),
	SILVER("Silver Calling Plan", "100 min free Canada wide calling"),
	BRONZE("Bronze Calling Plan", "30 min free Canada wide calling"),
	ZERO("Zero Calling Plan", "Zero min");
	
	/**
	 * The callingPlanOptionDescription will store the description for related calling plan.
	 */
	private String callingPlanOptionDescription;
	private String name;
	
	/**
	 * A constructor to invoke proper enum calling option
	 * @param name  it will store the name of the calling plan
	 * @param type  it will store the related plan description into callingPlanOptionDescription.
	 */
	private CallingPlanOptions(String name, String type) 
	{
		this.name = name;
		this.callingPlanOptionDescription=type;
		
	}
	
	/**
	 * It will return description for the invoked calling option.
	 * 
	 * @return callingPlanOptionDescription
	 */
	String getCallingPlanOptionsDesription() 
	{
		return callingPlanOptionDescription;
	}
	
	/**
	 * It will return name for the invoked calling option.
	 * 
	 * @return name of the calling plan
	 */
	String getCallingPlanName() 
	{
		return name;
	}	
	
}
