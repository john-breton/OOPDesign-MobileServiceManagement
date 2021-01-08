package bundlemanagement.pac;

/**
 * This class works as Bundle decorator for our PaC Bundle. This abstract class
 * is the superclass of all classes representing data, messaging, or calling
 * plans for the Plain and Customized bundle. All subclasses must define a
 * method that returns a description of the plan.
 * 
 * @author epahram
 *
 */
public abstract class BundleDecorator extends PaCBundle {
	/**
	 * This method returns a description of the phone plan added to the PaC bundle.
	 * 
	 * @return string Information about the phone plan(decorator).
	 */
	public abstract String getDescription();
}
