package bundlemanagement.preconf;

/**
 * This is an interface to create data plan for different plans.
 * 
 * @author epahram
 *
 */
public interface DataPlan {
	/**
	 * It will return information about data plan class.
	 * 
	 * @return DataPlan information.
	 */
	String toString();

	/**
	 * It will return data quantity for calling plan.
	 * 
	 * @return integer value of data plan.
	 */
	int getDataQuantity();
}
