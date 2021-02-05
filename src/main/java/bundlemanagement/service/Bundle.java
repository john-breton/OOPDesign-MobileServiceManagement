package bundlemanagement.service;

import java.math.BigDecimal;

/**The Bundle class is the abstract data type for the two bundle types.
 * It composed with a Name component which is the unique identifier of 
 * Bundle. 
 * @author enuyhza
 *
 */

public abstract class Bundle {
	BundleNames bundlename;

	
	/**
	 * Sets the bundle name for this bundle
	 * @param Name Bundle Name
	 */
	public void setName(BundleNames Name) {
		this.bundlename = Name;
	}

	/**
	 * Gets the bundle name for this bundle
	 * @return The bundle name for this bundle
	 */
	public BundleNames getName() {
		return bundlename;
	}
	
	public abstract BigDecimal cost();

}
