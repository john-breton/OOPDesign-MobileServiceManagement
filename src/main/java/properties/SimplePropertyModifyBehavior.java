/**
 * 
 */
package properties;

/**
 * @author edavleu
 *
 */
public class SimplePropertyModifyBehavior extends PropertyModifyBehaviorIf {

	@Override
	public <T> T change(T val) {
		System.out.println("-- Simple Modify Behavior called with: " + val.toString());
		return val;
	}

}
