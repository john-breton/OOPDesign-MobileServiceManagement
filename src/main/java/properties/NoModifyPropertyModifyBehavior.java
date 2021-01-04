/**
 * 
 */
package properties;

/**
 * @author edavleu
 *
 */
public class NoModifyPropertyModifyBehavior extends PropertyModifyBehaviorIf {

	@Override
	public <T> T change(T val) {
		// Do nothing
		System.out.println("-- No Modify Behavior called with: " + val.toString());
		return null;
	}

}
