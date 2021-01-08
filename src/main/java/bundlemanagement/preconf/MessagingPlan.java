package bundlemanagement.preconf;

/**
 * This is an interface to messaging plan for different plans.
 * 
 * @author epahram
 *
 */
public interface MessagingPlan {
	/**
	 * It will return information about messaging plan class.
	 * 
	 * @return Messaging plan information.
	 */
	String toString();

	/**
	 * It will return number of messages for related plan.
	 * 
	 * @return integer value of number of messages.
	 */
	int getNumberOfMessages();
}
