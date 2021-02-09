package bundlemanagement.service;

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
	PLATINUM("PLATINUM - Platinum Preconfigured Bundle", null), 
	GOLD("GOLD - Gold Preconfigured Bundle", null), 
	SILVER("SILVER - Silver Preconfigured Bundle", null),
	BRONZE("BRONZE - Bronze Preconfigured Bundle", null), 
	PICKANDCHOOSE("PAC - Pick and Choose Bundle", null),

	
	//Plain Pac Bundle
	PLAIN_PAC_BUNDLE("PLAINPACBUNDLE - Plain Pick and Choose Bundle", "Bare Bone Phone Service"),
	
	// PaC Bundle with calling plan options 
	PAC_WITH_GOLD_CALLING_PLAN("PACWITHGOLDCALLING - Pick and Choose Bundle with Gold Calling Plan", "Gold Calling Plan: Unlimited Canada wide calling"),
	PAC_WITH_PLATINUM_CALLING_PLAN("PACWITHPLATINUM - CALLINGPick and Choose Bundle with Platinum Calling Plan", "Platinum Calling Plan: Unlimited US & Canada wide calling"),
	PAC_WITH_BRONZE_CALLING_PLAN("PACWITHBRONZECALLING - Pick and Choose Bundle with Bronze Calling Plan", "Bronze Calling Plan: 30 min free Canada wide calling"),
	PAC_WITH_SILVER_CALLING_PLAN("PACWITHSILVERCALLING - Pick and Choose Bundle with Silver Calling Plan", "Silver Calling Plan: 100 min free Canada wide calling"),
	PAC_WITH_ZERO_CALLING_PLAN("PACWITHZEROCALLING - Pick and Choose Bundle with Zero Calling Plan", "Zero Calling Plan: Zero min"),

	// PaC Bundle with messaging plan options 
	PAC_WITH_GOLD_MESSAGING_PLAN("PACWITHGOLDMESSAGING - Pick and Choose Bundle with Gold Messaging Plan", "Gold Messaging Plan: 10K Messages"),
	PAC_WITH_PLATINUM_MESSAGING_PLAN("PACWITHPLATINUMMESSAGING - Pick and Choose Bundle with Platinum Messaging Plan", ":Platinum Messaging Plan: Unlimited Messaging"),
	PAC_WITH_BRONZE_MESSAGING_PLAN("PACWITHBRONZEMESSAGING - Pick and Choose Bundle with Bronze Messaging Plan", "Bronze Messaging Plan: 250 Messages"),
	PAC_WITH_SILVER_MESSAGING_PLAN("PACWITHSILVERMESSAGING - Pick and Choose Bundle with Silver Messaging Plan", "Silver Messaging Plan: 5K Messages"),
	PAC_WITH_ZERO_MESSAGING_PLAN("PACWITHZEROMESSAGING - Pick and Choose Bundle with Zero Messaging Plan", "Zero Messaging Plan: Zero Messages"),

	// PaC Bundle with data plan options names
	PAC_WITH_GOLD_DATA_PLAN("PACWITHGOLDDATA - Pick and Choose Bundle with Gold Data Plan", "Gold Data Plan: 7 GB"),
	PAC_WITH_PLATINUM_DATA_PLAN("PACWITHPLATINUMDATA - Pick and Choose Bundle with Platinum Data Plan", "Platinum Data Plan: 10 GB"),
	PAC_WITH_BRONZE_DATA_PLAN("PACWITHBRONZEDATA - Pick and Choose Bundle with Bronze Data Plan", "Bronze Data Plan: 2 GB"),
	PAC_WITH_SILVER_DATA_PLAN("PACWITHSILVERDATA - Pick and Choose Bundle with Silver Data Plan", "Silver Data Plan: 4 GB"),
	PAC_WITH_ZERO_DATA_PLAN("PACWITHZERODATA - Pick and Choose Bundle with Zero Data Plan", "Zero Data Plan: 0 GB"),

	//PaC Bundle without Plan options
	PAC_WITH_OUT_CALLING_PLAN("PACWITHOUTCALLING - PaC without Calling", "PaC Calling Plan: No Calling Plan"),
	PAC_WITH_OUT_MESSAGING_PLAN("PACWITHOUTMESSAGING - PaC without Messaging", "PaC Messaging Plan: No Messaging Plan"),
	PAC_WITH_OUT_DATA_PLAN("PACWITHOUTDATA - PaC without Data", "PaC Data Plan: No Data Plan");	
	
	/**
	 * The bundlename will store the name of bundles
	 * The bundleDescription will store the string description of bundles.
	 */
	private String bundlename;
	private String bundleDescription;

	/**
	 * enum constructor. It will set the bundle name and bundle description
	 * 
	 * @param bundlename It will store the string name of the bundle plan 
	 * @param desc       The description of the bundle plan
	 */
	BundleNames(String bundlename, String desc) {
		this.bundlename = bundlename;
		this.bundleDescription = desc;
	}

	/**
	 * This method return the bundle name.
	 * 
	 * @return bundle name
	 */
	public String getBundleNames() {
		return this.bundlename;
	}

	/**
	 * This method return the bundle description.
	 * 
	 * @return bundle description
	 */
	public String getBundleDescription() {
		return this.bundleDescription;
	}

}
