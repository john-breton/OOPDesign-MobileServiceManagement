package properties;

/**
 * Used to print the message if no modify behavior happened. 
 * @author David
 *
 */
public class NoModifyPropertyModifyBehavior extends PropertyModifyBehaviorIf {

	/**
	 * Will trigger upon change. Returns null if no modification is detected
	 *
	 * @param val The T value
	 * @return null if there is no modification, T otherwise.
	 * */
	@Override
	public <T> T change(T val) {
		// Do nothing
		System.out.println("-- No Modify Behavior called with: " + val.toString());
		return null;
	}

}
