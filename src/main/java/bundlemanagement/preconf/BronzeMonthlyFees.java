package bundlemanagement.preconf;

/**
 * This class implements monthly fee for bronze preconf plan.
 * 
 * @author epahram
 *
 */
public class BronzeMonthlyFees implements MonthlyFees {
	private static final int bronze_monthly_fee = 25;

	/**
	 * This method return monthly fee for bronze preconf plan.
	 * 
	 * @return bronze monthly fee.
	 */
	public int monthlyfee() {
		return bronze_monthly_fee;
	}
}
