/**
 * 
 */
package properties;

/**
 * Used to print the message if simple modify behavior happened. 
 * @author David
 *
 */
public class SimplePropertyModifyBehavior extends PropertyModifyBehaviorIf {
	
	/**
	 * Will trigger upon change. Returns null if simple modification detected

	 * @param T val
	 * @return T
	 * */
	@Override
	public <T> T change(T val) {
		System.out.println("-- Simple Modify Behavior called with: " + val.toString());
		return val;
	}

}
