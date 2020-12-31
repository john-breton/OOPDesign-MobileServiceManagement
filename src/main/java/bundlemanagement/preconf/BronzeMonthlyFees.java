package bundlemanagement.preconf;

public class BronzeMonthlyFees implements MonthlyFees {
	private static final int bronze_monthly_fee = 25;

	public int monthlyfee() {
		return bronze_monthly_fee;
	}
}
