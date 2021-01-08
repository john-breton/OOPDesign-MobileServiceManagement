package bundlemanagement.preconf;

/**
 * This is an interface to create monthly fee for different plans.
 * 
 * @author epahram
 *
 */
public interface MonthlyFees {

	/**
	 * The method get the monthly fee from related concrete class, and return it to
	 * related bundle at PrecconfBundle.
	 * 
	 * @return fee for monthly fee.
	 */
	int monthlyfee();
}
