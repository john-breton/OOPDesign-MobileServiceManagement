package bundlemanagement.pac;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import bundlemanagement.preconf.BundleNames;

public class BundleNumericalValues {
	
	
	/**
	 * Create a map for PaC bundle with calling plan options.
	 * It will represent numerical values for calling plan. Total minutes of calling for each plan.
	 */
	
	public static Map<BundleNames, BigDecimal> PaCWithCallingOptionTotalMinutes=new EnumMap<BundleNames,BigDecimal>(BundleNames.class);
	
	/**
	 * Import fee for PaC bundle with different calling plan options.
	 */
	static {
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PACWITHPLATINUMCALLINGPLAN,new BigDecimal(Double.MAX_VALUE));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PACWITHGOLDCALLINGPLAN,new BigDecimal(Double.MAX_VALUE));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PACWITHSILVERCALLINGPLAN,new BigDecimal(100));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PACWITHBRONZECALLINGPLAN,new BigDecimal(30));
		PaCWithCallingOptionTotalMinutes.put(BundleNames.PACWITHZEROCALLINGPLAN,new BigDecimal(0));

		//Make map unmodifiable(read-only) by user.
		PaCWithCallingOptionTotalMinutes=Collections.unmodifiableMap(PaCWithCallingOptionTotalMinutes);
		
	}
	
	/**
	 * Create a map for PaC bundle with data plan options.
	 * It will represent numerical values for data plan.Total amount of data for each plan. 
	 */
	
	public static Map<BundleNames, BigDecimal> PaCWithDataOptionDataQuantity=new EnumMap<BundleNames,BigDecimal>(BundleNames.class);
	
	/**
	 * Import fee for PaC bundle with different data plan options.
	 */
	static {
		PaCWithDataOptionDataQuantity.put(BundleNames.PACWITHPLATINUMDATAPLAN,new BigDecimal(10));
		PaCWithDataOptionDataQuantity.put(BundleNames.PACWITHGOLDDATAPLAN,new BigDecimal(7));
		PaCWithDataOptionDataQuantity.put(BundleNames.PACWITHSILVERDATAPLAN,new BigDecimal(4));
		PaCWithDataOptionDataQuantity.put(BundleNames.PACWITHBRONZEDATAPLAN,new BigDecimal(2));
		PaCWithDataOptionDataQuantity.put(BundleNames.PACWITHZERODATAPLAN,new BigDecimal(0));

		//Make map unmodifiable(read-only) by user.
		PaCWithDataOptionDataQuantity=Collections.unmodifiableMap(PaCWithDataOptionDataQuantity);
		
	}
	
	/**
	 * Create a map for PaC bundle with messaging plan options.
	 *  It will represent numerical values for messaging plan.Total Number of Messages for each plan.
	 */
	
	public static Map<BundleNames, BigDecimal> PaCWithMessagingOptionTotalNumberOfMessages=new EnumMap<BundleNames,BigDecimal>(BundleNames.class);
	
	/**
	 * Import fee for PaC bundle with different massaging plan options.
	 */
	static {
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PACWITHPLATINUMMESSAGINGPLAN,new BigDecimal(Double.MAX_VALUE));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PACWITHGOLDMESSAGINGPLAN,new BigDecimal(10000));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PACWITHSILVERMESSAGINGPLAN,new BigDecimal(5000));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PACWITHBRONZEMESSAGINGPLAN,new BigDecimal(250));
		PaCWithMessagingOptionTotalNumberOfMessages.put(BundleNames.PACWITHZEROMESSAGINGPLAN,new BigDecimal(0));

		//Make map unmodifiable(read-only) by user.
		PaCWithMessagingOptionTotalNumberOfMessages=Collections.unmodifiableMap(PaCWithMessagingOptionTotalNumberOfMessages);
		
	}

}
