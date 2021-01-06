package bundlemanagement.pac;

public abstract class PaCBundle {
	/**
	 * Assign initial value to PaC bundle.
	 */
	String description = "Unknown pick and customized bundle";
	int fee = 0;

	public String getDescription() {
		return description;
	}

	public abstract int cost();
}
