package bundlemanagement.preconf;

public class GoldMonthlyFees implements MonthlyFees {
	private static final int gold_monthly_fee = 80;

	public int monthlyfee() {
		return gold_monthly_fee;
	}
}
