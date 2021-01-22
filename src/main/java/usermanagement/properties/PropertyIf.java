package usermanagement.properties;

/**
 * PropertyIf is an interface for the property
 * @author David
 *
 */
public abstract class PropertyIf<T> {

	protected String propertyName;
	protected T propertyValue;
	
	protected PropertyModifyBehaviorIf propertyModifyBehavior;
	/**
	 * Getter for the value of the property
	 * @return T propertyValue
	 * */
	public T getValue() {
		return propertyValue;
	}
	
	/**
	 * Setter for the value of the property
	 * @param val The value to be set to T
	 * */
	public void setValue(T val) {
		T newVal = propertyModifyBehavior.change(val);
		
		if (newVal != null) {
			propertyValue = val;	
		}
	}
	
	/**
	 * printing detailed information about current property
	 * @return String the details of current property
	 * */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(propertyName).append(": ").append(propertyValue);
		
		return result.toString();
	}
	
	/**
	 * add modify behavior to current property
	 * @param pmb The propertyModifyBehaviour to be associated with the current Object
	 * */
	public void setPropertyModifyBehavior(PropertyModifyBehaviorIf pmb) {
		propertyModifyBehavior = pmb;
	}
}
