package bundlemanagement.pac;

/**
 * This class is responsible to create bare bone phone service for the PaC
 * bundle. This is the decorate.
 * 
 * @author Ramin Pahlevannejad
 *
 */

public class BareBonePhoneService extends PaCBundle {

	private static final String BARE_BONES_PHONE_SERVICE_DESCRIPTION = "Bare Bone Phone Service\n";
	private static final int BARE_BONES_PHONE_SERVICE_FEE = 10;

	/**
	 * The constructor will assign value to barebone phone services.
	 */
	public BareBonePhoneService() {
		description = BARE_BONES_PHONE_SERVICE_DESCRIPTION;
		fee = BARE_BONES_PHONE_SERVICE_FEE;
	}

	/**
	 * This method set up flat rate for bare bone service.
	 * 
	 * @return it will return bare bone phone service fee to PaC Bundle.
	 */
	@Override
	public int cost() {
		// return fixed flat rate
		return fee;
	}
}
