package bundlemanagement.preconf;

public enum MessagingPlanOptions {

	/**
	 * Messaging Plan Options
	 */
	PLATINUM("Unlimited Messages"), GOLD("10K Messages"),
	SILVER("5K Messages"), BRONZE("250 Messages"), ZERO("0 Message");

	/**
	 * The messagingPlanOptionDescription will store the description for related
	 * messaging plan.
	 */
	private String messagingPlanOptionDescription;

	/**
	 * A constructor to invoke proper enum messaging plan option
	 * 
	 * @param type it will store the related plan description into
	 *             messagingPlanOptionDescription.
	 */
	private MessagingPlanOptions(String type) {
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

}
