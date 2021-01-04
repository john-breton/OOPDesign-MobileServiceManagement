/**
 * 
 */
package properties;

/**
 * @author edavleu
 *
 */
public abstract class PropertyIf<T> {

	protected String propertyName;
	protected T propertyValue;
	
	protected PropertyModifyBehaviorIf propertyModifyBehavior;
	
	public T getValue() {
		return propertyValue;
	}
	
	public void setValue(T val) {
		T newVal = propertyModifyBehavior.change(val);
		
		if (newVal != null) {
			propertyValue = val;	
		}
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(propertyName).append(": ").append(propertyValue);
		
		return result.toString();
	}
	
	public void setPropertyModifyBehavior(PropertyModifyBehaviorIf pmb) {
		propertyModifyBehavior = pmb;
	}
}
