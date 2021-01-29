package bundlemanagement.pac;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import bundlemanagement.service.BundleNames;

public class BundleNumericalValues {
	
	
	/**
	 * Create a map for PaC bundle with calling plan options.
	 * It will represent numerical values for calling plan. Total minutes of calling for each plan.
	 */
	
	public static Map<BundleNames, BigDecimal> PaCWithCallingOptionTotalMinutes = new EnumMap<BundleNames,BigDecimal>(BundleNames.class);
	
	/**
	 * Import fee for PaC bundle with different calling plan options.
	 */
	static {
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PAC_WITH_PLATINUM_CALLING_PLAN, new BigDecimal(Double.MAX_VALUE));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PAC_WITH_GOLD_CALLING_PLAN, new BigDecimal(Double.MAX_VALUE));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PAC_WITH_SILVER_CALLING_PLAN, new BigDecimal(100));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PAC_WITH_BRONZE_CALLING_PLAN, new BigDecimal(30));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PAC_WITH_ZERO_CALLING_PLAN, new BigDecimal(0));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PAC_WITH_OUT_CALLING_PLAN, new BigDecimal(0));

		//Make map unmodifiable(read-only) by user.
		PaCWithCallingOptionTotalMinutes=Collections.unmodifiableMap(PaCWithCallingOptionTotalMinutes);
		
	}
	
	/**
	 * Create a map for PaC bundle with data plan options.
	 * It will represent numerical values for data plan.Total amount of data for each plan. 
	 */
	
	public static Map<BundleNames, BigDecimal> PaCWithDataOptionDataQuantity = new EnumMap<BundleNames,BigDecimal>(BundleNames.class);
	
	/**
	 * Import fee for PaC bundle with different data plan options.
	 */
	static {
		PaCWithDataOptionDataQuantity.put(BundleNames.PAC_WITH_PLATINUM_DATA_PLAN, new BigDecimal(10));
		PaCWithDataOptionDataQuantity.put(BundleNames.PAC_WITH_GOLD_DATA_PLAN, new BigDecimal(7));
		PaCWithDataOptionDataQuantity.put(BundleNames.PAC_WITH_SILVER_DATA_PLAN, new BigDecimal(4));
		PaCWithDataOptionDataQuantity.put(BundleNames.PAC_WITH_BRONZE_DATA_PLAN, new BigDecimal(2));
		PaCWithDataOptionDataQuantity.put(BundleNames.PAC_WITH_ZERO_DATA_PLAN, new BigDecimal(0));
		PaCWithDataOptionDataQuantity.put(BundleNames.PAC_WITH_OUT_DATA_PLAN, new BigDecimal(0));
		//Make map unmodifiable(read-only) by user.
		PaCWithDataOptionDataQuantity=Collections.unmodifiableMap(PaCWithDataOptionDataQuantity);
		
	}
	
	/**
	 * Create a map for PaC bundle with messaging plan options.
	 *  It will represent numerical values for messaging plan.Total Number of Messages for each plan.
	 */
	
	public static Map<BundleNames, BigDecimal> PaCWithMessagingOptionTotalNumberOfMessages = new EnumMap<BundleNames,BigDecimal>(BundleNames.class);
	
	/**
	 * Import fee for PaC bundle with different massaging plan options.
	 */
	static {
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PAC_WITH_PLATINUM_MESSAGING_PLAN, new BigDecimal(Double.MAX_VALUE));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PAC_WITH_GOLD_MESSAGING_PLAN, new BigDecimal(10000));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PAC_WITH_SILVER_MESSAGING_PLAN, new BigDecimal(5000));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PAC_WITH_BRONZE_MESSAGING_PLAN, new BigDecimal(250));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PAC_WITH_ZERO_MESSAGING_PLAN, new BigDecimal(0));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PAC_WITH_OUT_MESSAGING_PLAN, new BigDecimal(0));
		//Make map unmodifiable(read-only) by user.
		PaCWithMessagingOptionTotalNumberOfMessages=Collections.unmodifiableMap(PaCWithMessagingOptionTotalNumberOfMessages);
		
	}

}
