package bundlemanagement.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * This class contains all information about bundle fees.
 * 
 * @author epahram
 *
 */

public class BundleFees {

	/**
	 * Create a map for preconf bundle fee.
	 */
	public static Map<BundleNames, BigDecimal> preconfFees = new EnumMap<BundleNames, BigDecimal>(BundleNames.class);

	/**
	 * Import fee for each precofigured bundle into enum map.
	 *
	 */
	static {
		preconfFees.put(BundleNames.PLATINUM, new BigDecimal(100));
		preconfFees.put(BundleNames.GOLD, new BigDecimal(80));
		preconfFees.put(BundleNames.SILVER, new BigDecimal(45));
		preconfFees.put(BundleNames.BRONZE, new BigDecimal(25));

		// Make map unmodifiable(read-only) by user.
		preconfFees = Collections.unmodifiableMap(preconfFees);

	}

	/**
	 * Create a map for PaC bundle with calling plan options fee.
	 */

	public static Map<BundleNames, BigDecimal> PaCWithCallingOptionFees = new EnumMap<BundleNames, BigDecimal>(
			BundleNames.class);

	/**
	 * Import fee for PaC bundle with different calling plan options.
	 */
	static {
		PaCWithCallingOptionFees.put(BundleNames.PAC_WITH_PLATINUM_CALLING_PLAN, new BigDecimal(40));
		PaCWithCallingOptionFees.put(BundleNames.PAC_WITH_GOLD_CALLING_PLAN, new BigDecimal(30));
		PaCWithCallingOptionFees.put(BundleNames.PAC_WITH_SILVER_CALLING_PLAN, new BigDecimal(20));
		PaCWithCallingOptionFees.put(BundleNames.PAC_WITH_BRONZE_CALLING_PLAN, new BigDecimal(15));
		PaCWithCallingOptionFees.put(BundleNames.PAC_WITH_ZERO_CALLING_PLAN, new BigDecimal(0));

		// Make map unmodifiable(read-only) by user.
		PaCWithCallingOptionFees = Collections.unmodifiableMap(PaCWithCallingOptionFees);

	}

	/**
	 * Create a map for PaC bundle with data plan options fee.
	 */

	public static Map<BundleNames, BigDecimal> PaCWithDataOptionFees = new EnumMap<BundleNames, BigDecimal>(
			BundleNames.class);

	/**
	 * Import fee for PaC bundle with different data plan options.
	 */
	static {
		PaCWithDataOptionFees.put(BundleNames.PAC_WITH_PLATINUM_DATA_PLAN, new BigDecimal(40));
		PaCWithDataOptionFees.put(BundleNames.PAC_WITH_GOLD_DATA_PLAN, new BigDecimal(30));
		PaCWithDataOptionFees.put(BundleNames.PAC_WITH_SILVER_DATA_PLAN, new BigDecimal(25));
		PaCWithDataOptionFees.put(BundleNames.PAC_WITH_BRONZE_DATA_PLAN, new BigDecimal(20));
		PaCWithDataOptionFees.put(BundleNames.PAC_WITH_ZERO_DATA_PLAN, new BigDecimal(0));

		// Make map unmodifiable(read-only) by user.
		PaCWithDataOptionFees = Collections.unmodifiableMap(PaCWithDataOptionFees);

	}

	/**
	 * Create a map for PaC bundle with messaging plan options fee.
	 */

	public static Map<BundleNames, BigDecimal> PaCWithMessagingOptionFees = new EnumMap<BundleNames, BigDecimal>(
			BundleNames.class);

	/**
	 * Import fee for PaC bundle with different massaging plan options.
	 */
	static {
		PaCWithMessagingOptionFees.put(BundleNames.PAC_WITH_PLATINUM_MESSAGING_PLAN, new BigDecimal(45));
		PaCWithMessagingOptionFees.put(BundleNames.PAC_WITH_GOLD_MESSAGING_PLAN, new BigDecimal(35));
		PaCWithMessagingOptionFees.put(BundleNames.PAC_WITH_SILVER_MESSAGING_PLAN, new BigDecimal(25));
		PaCWithMessagingOptionFees.put(BundleNames.PAC_WITH_BRONZE_MESSAGING_PLAN, new BigDecimal(20));
		PaCWithMessagingOptionFees.put(BundleNames.PAC_WITH_ZERO_MESSAGING_PLAN, new BigDecimal(0));

		// Make map unmodifiable(read-only) by user.
		PaCWithMessagingOptionFees = Collections.unmodifiableMap(PaCWithMessagingOptionFees);

	}
}
