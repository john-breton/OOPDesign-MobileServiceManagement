/**
 * 
 */
package UserService;

/**
 * @author edavleu
 *
 */
public class UserNameProperty extends PropertyIf<String> {
	
	public UserNameProperty(String name) {
		propertyName = "User Name";
		
		propertyValue = name;
		setPropertyModifyBehavior(new NoModifyPropertyModifyBehavior());
	}

}
