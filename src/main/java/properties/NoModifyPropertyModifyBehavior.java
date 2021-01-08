/**
 * 
 */
package properties;

/**
 * Used to print the message if no modify behavior happened. 
 * @author David
 *
 */
public class NoModifyPropertyModifyBehavior extends PropertyModifyBehaviorIf {

	/**
	 * Will triggered upon change. return null if no modification detected
	 * @param T val
	 * @return T
	 * */
	@Override
	public <T> T change(T val) {
		// Do nothing
		System.out.println("-- No Modify Behavior called with: " + val.toString());
		return null;
	}

}
