package bundlemanagement.preconf;

/**
 * This class implements monthly fee for platinum preconf plan.
 * 
 * @author epahram
 *
 */
public class PlatinumMonthlyFees implements MonthlyFees {
	private static final int platinum_monthly_fee = 100;

	/**
	 * This method return monthly fee for platinum preconf plan.
	 * 
	 * @return platinum monthly fee.
	 */
	public int monthlyfee() {
		return platinum_monthly_fee;
	}
}
