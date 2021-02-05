package bundlemanagement.pac;

import bundlemanagement.service.BundleNames;
import bundlemanagement.service.BundleOption;

/**
 * This SimplePaCBundleFactory class will create the PaC Bundle.
 * 
 * @author enuyhza
 *
 */
public class SimplePaCBundleFactory {
	/**
	 * Create PaC Bundle based on the passing parameters
	 * 
	 * @param name            The name for the PaC bundle
	 * @param callingOption   The calling option for the PaC bundle (PLATINUM, GOLD,
	 *                        SILVER, or BRONZE)
	 * @param messagingOption The messaging option for the PaC bundle (PLATINUM,
	 *                        GOLD, SILVER, or BRONZE)
	 * @param dataOption      The data option for the PaC bundle (PLATINUM, GOLD,
	 *                        SILVER, or BRONZE)
	 * @return The pac bundle object
	 */
	public PaCBundle createBundle(BundleNames name, BundleOption callingOption, BundleOption messagingOption,
			BundleOption dataOption) {
		PaCBundle pac = new BareBonePhoneService();

		if (callingOption != null) {
			switch (callingOption) {
			case PLATINUM:
				pac = new PlatinumCallingPlan(pac);
				break;
			case GOLD:
				pac = new GoldCallingPlan(pac);
				break;
			case SILVER:
				pac = new SilverCallingPlan(pac);
				break;
			case BRONZE:
				pac = new BronzeCallingPlan(pac);
				break;
			case ZERO:
				pac = new ZeroCallingPlan(pac);
				break;
			case NONE:
				pac = new EmptyCallingPlan(pac);
				break;
			}
		}
		
		if (messagingOption != null) {
			switch (messagingOption) {
			case PLATINUM:
				pac = new PlatinumMessagingPlan(pac);
				break;
			case GOLD:
				pac = new GoldMessagingPlan(pac);
				break;
			case SILVER:
				pac = new SilverMessagingPlan(pac);
				break;
			case BRONZE:
				pac = new BronzeMessagingPlan(pac);
				break;
			case ZERO:
				pac = new ZeroMessagingPlan(pac);
				break;
			case NONE:
				pac = new EmptyMessagingPlan(pac);
			}
		}
		
		if (dataOption != null) {
			switch (dataOption) {
			case PLATINUM:
				pac = new PlatinumDataPlan(pac);
				break;
			case GOLD:
				pac = new GoldDataPlan(pac);
				break;
			case SILVER:
				pac = new SilverDataPlan(pac);
				break;
			case BRONZE:
				pac = new BronzeDataPlan(pac);
				break;
			case ZERO:
				pac = new ZeroDataPlan(pac);
				break;
			case NONE:
				pac = new EmptyDataPlan(pac);
				break;
			}
		}
		pac.setName(name);
		return pac;

	}

}
