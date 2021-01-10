package bundlemanagement.pac;

import bundlemanagement.service.*;

/**
 * This class is an abstract class to implement PaC bundle.
 * 
 * @author epahram
 *
 */
public abstract class PaCBundle extends Bundle {
	String description = "Unknown plain and customized bundle";
	int fee = 0;

	/**
	 * This method returns a description of the plan(s) associated with this PaC
	 * bundle.
	 * 
	 * @return description for all decorator parts of PaC bundle.
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * It will set cost for each decorator user choose.
	 * 
	 * @return fee for each decorator
	 */
	public abstract int cost();
}
