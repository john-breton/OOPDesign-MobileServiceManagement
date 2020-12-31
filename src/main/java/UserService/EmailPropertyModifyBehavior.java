/**
 * 
 */
package UserService;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author edavleu
 *
 */
public class EmailPropertyModifyBehavior extends PropertyModifyBehaviorIf {
	private static final Pattern VALID_EMAIL_REGEX = Pattern.compile("[a-zA-Z0-9.-_+]+@[a-zA-Z0-9.-_+]+\\.[a-zA-Z0-9.-_+]+");

	@Override
	public <T> T change(T val) {
		System.out.println("-- Email Property Modify behavior called with " + val);
		
		// Validate that <val> is a valid email
		Matcher m = VALID_EMAIL_REGEX.matcher(val.toString());
		
		if (!m.find()) {
			System.out.println("--- Invalid email!");
			return null;
		}
		
		return val;
	}

}
