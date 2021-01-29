package bundlemanagement.preconf;

public enum MessagingPlanOptions {

	/**
	 * Messaging Plan Options
	 */
	PLATINUM("Platinum Messaging Plan", "Unlimited Messages"), 
	GOLD("Gold Messaging Plan", "10K Messages"),
	SILVER("Silver Messaging Plan", "5K Messages"), 
	BRONZE("Bronze Messaging Plan", "250 Messages"), 
	ZERO("Zero Messaging Plan", "0 Message");

	/**
	 * The messagingPlanOptionDescription will store the description for related
	 * messaging plan.
	 */
	private String messagingPlanOptionDescription;
	private String name;

	/**
	 * A constructor to invoke proper enum messaging plan option
	 * 
	 * @param name it will store the name of Messaging Plan
	 * @param type it will store the related plan description into
	 *             messagingPlanOptionDescription.
	 */
	MessagingPlanOptions(String name, String type) {
		this.name = name;
		this.messagingPlanOptionDescription = type;
	}

	/**
	 * It will return description for the invoked messaging plan option.
	 * 
	 * @return messagingPlanOptionDescription
	 */
	String getdMessagingPlanOptionsDesription() {
		return messagingPlanOptionDescription;
	}
	
	/**
	 * It will return description for the invoked messaging plan option.
	 * 
	 * @return messagingPlanOptionDescription
	 */
	String getdMessagingPlanName() {
		return name;
	}

}
