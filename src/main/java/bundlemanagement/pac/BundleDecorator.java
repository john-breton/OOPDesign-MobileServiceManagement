package bundlemanagement.pac;

/**
 * This class works as Bundle decorator for our PaC Bundle.
 * 
 * @author epahram
 *
 */
public abstract class BundleDecorator extends PaCBundle {
	/**
	 * This method will setup description for each decorator user choose.
	 * 
	 * @return string information of decorator.
	 */
	public abstract String getDescription();
}
