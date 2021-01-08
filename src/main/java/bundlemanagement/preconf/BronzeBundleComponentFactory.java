package bundlemanagement.preconf;

import bundlemanagement.component.*;

/**
 * This Class implements Bronze Bundle Component Factory.
 * 
 * It will return instance of bronze related components to preconfBundle in
 * order to make bronze preconf plan.
 * 
 * @author epahram
 *
 */
public class BronzeBundleComponentFactory implements BundleComponentFactory {

	/**
	 * This method return instance of bronze calling plan.
	 * 
	 * @return calling plan to PreconfBundle class to create bronze preconf plan.
	 */
	public CallingPlan createCallingPlan() {

		return new BronzeCallingPlan();
	}

	/**
	 * This method return instance of Bronze messaging plan.
	 * 
	 * @return messaging plan to PreconfBundle class to create bronze preconf plan.
	 */
	public MessagingPlan createMessagingPlan() {

		return new BronzeMessagingPlan();
	}

	/**
	 * This method return instance of Bronze data plan.
	 * 
	 * @return data plan to PreconfBundle class to create bronze preconf plan.
	 */
	public DataPlan createDataPaln() {

		return new BronzeDataPlan();
	}

	/**
	 * This method return instance of bronze monthly fee for Bronze preconf plan.
	 * 
	 * @return Monthly fee to PreconfBundle class to create bronze preconf plan.
	 */
	public MonthlyFees createMonthlyFees() {

		return new BronzeMonthlyFees();
	}

}
