package bundlemanagement.preconf;

/**
 * This class implements monthly fee for gold preconf plan.
 * 
 * @author epahram
 *
 */
public class GoldMonthlyFees implements MonthlyFees {
	private static final int gold_monthly_fee = 80;

	/**
	 * This method return monthly fee for gold preconf plan.
	 * 
	 * @return gold monthly fee.
	 */
	public int monthlyfee() {
		return gold_monthly_fee;
	}
}
