package bundlemanagement.preconf;

public class SilverMonthlyFees implements MonthlyFees {
	private static final int silver_monthly_fee = 45;

	public int monthlyfee() {
		return silver_monthly_fee;
	}
}
