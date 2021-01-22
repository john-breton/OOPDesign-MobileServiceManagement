package bundlemanagement.preconf;


public enum CallingPlanOptions {
	
	/**
	 * Calling Plan Options
	 */
	PLATINUM("Unlimited US & Canada wide calling"),
	GOLD("Unlimited Canada wide calling"),
	SILVER("100 min free Canada wide calling"),
	BRONZE("30 min free Canada wide calling"),
	ZERO("Zero min");
	
	/**
	 * The callingPlanOptionDescription will store the description for related calling plan.
	 */
	private String callingPlanOptionDescription;
	
	/**
	 * A constructor to invoke proper enum calling option
	 * @param type it will store the related plan description into callingPlanOptionDescription.
	 */
	private CallingPlanOptions(String type) 
	{
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
	
}
