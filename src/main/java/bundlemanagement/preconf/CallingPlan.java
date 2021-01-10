package bundlemanagement.preconf;

/**
 * This is an interface to create calling plan for different plans.
 * 
 * @author epahram
 *
 */

public interface CallingPlan {
	/**
	 * It will return information about calling plan class.
	 * 
	 * @return CallingPlan information.
	 */
	String toString();

	/**
	 * It will return minutes for calling plan.
	 * 
	 * @return integer value of calling plan.
	 */
	int getCallingMinutes();
}
