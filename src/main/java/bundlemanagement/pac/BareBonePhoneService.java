package bundlemanagement.pac;

import java.math.BigDecimal;

import bundlemanagement.preconf.*;
import bundlemanagement.service.BundleNames;

/**
 * This class is responsible for creating the bare bone phone service for the
 * PaC bundle. This is the decorator.
 * 
 * @author epahram
 *
 */

public class BareBonePhoneService extends PaCBundle {

	private static final BigDecimal BARE_BONES_PHONE_SERVICE_FEE = new BigDecimal(10);

	/**
	 * The constructor will assign value to barebone phone services.
	 */
	public BareBonePhoneService() {
		description = BundleNames.PLAIN_PAC_BUNDLE.getBundleDescription() + "\n";
		fee = BARE_BONES_PHONE_SERVICE_FEE;
	}

	/**
	 * This method set up flat rate for bare bone service.
	 * 
	 * @return it will return bare bone phone service fee to PaC Bundle.
	 */
	@Override
	public BigDecimal cost() {
		// return fixed flat rate
		return fee;
	}
}
