package bundlemanagement.pac;

public class ZeroCallingPlan extends BundleDecorator {

	private final PaCBundle pacbundle;
	private static final int ZERO_CALLING_MINUTES = 0;
	private static final int ZERO_CALLING_PLAN_FEE = 0;
	private static final String ZERO_CALLING_DESCRIPTION = "Zero: Zero min";

	public ZeroCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return pacbundle.getDescription() + ZERO_CALLING_DESCRIPTION + "\n";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return pacbundle.cost() + ZERO_CALLING_PLAN_FEE;
	}

	public int getCallingMinutes() {
		// TODO Auto-generated method stub
		return ZERO_CALLING_MINUTES;
	}

}
