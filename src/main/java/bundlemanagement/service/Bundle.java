package bundlemanagement.service;


/**The Bundle class is the abstract data type for the two bundle types.
 * It composed with a Name component which is the unique identifier of 
 * Bundle. 
 * @author enuyhza
 *
 */
public abstract class Bundle {
	private String Name;

	
	/**
	 * Sets the bundle name for this bundle
	 * @param Name Bundle Name
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * Gets the bundle name for this bundle
	 * @return The bundle name for this bundle
	 */
	public String getName() {
		return Name;
	}

}
