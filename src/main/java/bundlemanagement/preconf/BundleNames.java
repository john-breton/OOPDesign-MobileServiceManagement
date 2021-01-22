package bundlemanagement.preconf;

/**
 * This enum class contains name and description for all bundles.
 * 
 * @author epahram
 *
 */
public enum BundleNames {

	/**
	 * List of bundle names
	 */

	// Pre-configured (preconf) bundle names
	PLATINUM("Platinum Preconfigured Bundle"), GOLD("Gold Preconfigured Bundle"), SILVER("Silver Preconfigured Bundle"),
	BRONZE("Bronze Preconfigured Bundle"), PICKANDCHOOSE("Pick and Choose Bundle"),

	// PaCBundle
	PACBUNDLE("Unknown plain and customized bundle"),

	// PaC Bundle Bare Bone phone service
	PACWITHBAREBONEPHONESERVICE("Bare Bone Phone Service"),

	// PaC Bundle with calling plan options names
	PACWITHGOLDCALLINGPLAN("PaC Gold Calling Plan: Unlimited Canada wide calling"),
	PACWITHPLATINUMCALLINGPLAN("PaC Platinum Calling Plan: Unlimited US & Canada wide calling"),
	PACWITHBRONZECALLINGPLAN("PaC Bronze Calling Plan: 30 min free Canada wide calling"),
	PACWITHSILVERCALLINGPLAN("PaC Silver Calling Plan: 100 min free Canada wide calling"),
	PACWITHZEROCALLINGPLAN("PaC Zero Calling Plan: Zero min"),

	// PaC Bundle with messaging plan options names
	PACWITHGOLDMESSAGINGPLAN("PaC Gold Messaging Plan: 10K Messages"),
	PACWITHPLATINUMMESSAGINGPLAN("PaC Platinum Messaging Plan: Unlimited Messaging"),
	PACWITHBRONZEMESSAGINGPLAN("PaC Bronze Messaging Plan: 250 Messages"),
	PACWITHSILVERMESSAGINGPLAN("PaC Silver Messaging Plan: 5K Messages"),
	PACWITHZEROMESSAGINGPLAN("PaC Zero Messaging Plan: Zero Messages"),

	// PaC Bundle with data plan options names
	PACWITHGOLDDATAPLAN("PaC Gold Data Plan: 7 GB"), PACWITHPLATINUMDATAPLAN("PaC Platinum Data Plan: 10 GB"),
	PACWITHBRONZEDATAPLAN("PaC Bronze Data Plan: 2 GB"), PACWITHSILVERDATAPLAN("PaC Silver Data Plan: 4 GB"),
	PACWITHZERODATAPLAN("PaC Zero Data Plan: 0 GB");

	/**
	 * The bundle name will store the string description of bundles.
	 */
	private String bundlename;

	/**
	 * enum constructor. It will set the bundle name.
	 * 
	 * @param bundlename
	 */
	private BundleNames(String bundlename) {
		this.bundlename = bundlename;
	}

	/**
	 * This method return the bundle name.
	 * 
	 * @return bundle name
	 */
	public String getBundleNames() {
		return this.bundlename;
	}

}
