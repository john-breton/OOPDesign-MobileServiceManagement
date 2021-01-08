package bundlemanagement.preconf;

/**
 * This class implements monthly fee for silver preconf plan.
 * 
 * @author epahram
 *
 */

public class SilverMonthlyFees implements MonthlyFees {
	private static final int silver_monthly_fee = 45;

	/**
	 * This method return monthly fee for silver preconf plan.
	 * 
	 * @return silver monthly fee.
	 */
	public int monthlyfee() {
		return silver_monthly_fee;
	}
}
