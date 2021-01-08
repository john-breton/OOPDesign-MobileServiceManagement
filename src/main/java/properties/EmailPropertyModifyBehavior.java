/**
 * 
 */
package properties;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Used to validate the format of email property. 

 * @author David
 *
 */
public class EmailPropertyModifyBehavior extends PropertyModifyBehaviorIf {
	private static final Pattern VALID_EMAIL_REGEX = Pattern.compile("[a-zA-Z0-9.-_+]+@[a-zA-Z0-9.-_+]+\\.[a-z]+");
	
	/**
	 * Will trigger upon change. Returns null if the email address is invalid

	 * @param T val
	 * @return T
	 * */
	@Override
	public <T> T change(T val) {
		System.out.println("-- Email Property Modify behavior called with " + val);

		if (val == null || val.toString().equals("")) {
			return val;
		}
		// Validate that <val> is a valid email
		Matcher m = VALID_EMAIL_REGEX.matcher(val.toString());

		if (!m.find()) {
			System.out.println("--- Invalid email!");
			return null;
		}

		return val;
	}

}
