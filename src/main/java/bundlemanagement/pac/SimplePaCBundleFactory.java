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
			pac = switch (callingOption) {
				case PLATINUM -> new PlatinumCallingPlan(pac);
				case GOLD -> new GoldCallingPlan(pac);
				case SILVER -> new SilverCallingPlan(pac);
				case BRONZE -> new BronzeCallingPlan(pac);
				case ZERO -> new ZeroCallingPlan(pac);
				case NONE -> new EmptyCallingPlan(pac);
				default -> pac;
			};
		}
		
		if (messagingOption != null) {
			pac = switch (messagingOption) {
				case PLATINUM -> new PlatinumMessagingPlan(pac);
				case GOLD -> new GoldMessagingPlan(pac);
				case SILVER -> new SilverMessagingPlan(pac);
				case BRONZE -> new BronzeMessagingPlan(pac);
				case ZERO -> new ZeroMessagingPlan(pac);
				case NONE -> new EmptyMessagingPlan(pac);
				default -> pac;
			};
		}
		
		if (dataOption != null) {
			pac = switch (dataOption) {
				case PLATINUM -> new PlatinumDataPlan(pac);
				case GOLD -> new GoldDataPlan(pac);
				case SILVER -> new SilverDataPlan(pac);
				case BRONZE -> new BronzeDataPlan(pac);
				case ZERO -> new ZeroDataPlan(pac);
				case NONE -> new EmptyDataPlan(pac);
				default -> pac;
			};
		}
		pac.setName(name);
		return pac;

	}

}
