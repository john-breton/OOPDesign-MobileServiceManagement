package bundlemanagement.pac;

public class BareBonePhoneService extends PaCBundle {

	private static final String BARE_BONES_PHONE_SERVICE_DESCRIPTION = "Bare Bone Phone Service\n";
	private static final int BARE_BONES_PHONE_SERVICE_FEE = 10;

	public BareBonePhoneService() {
		description = BARE_BONES_PHONE_SERVICE_DESCRIPTION;
		fee = BARE_BONES_PHONE_SERVICE_FEE;
	}

	@Override
	public int cost() {
		// return fixed flat rate
		return fee;
	}
}
