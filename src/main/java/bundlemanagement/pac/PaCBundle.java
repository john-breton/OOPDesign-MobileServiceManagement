package bundlemanagement.pac;

public abstract class PaCBundle {
	String description = "Unknown pick and customized bundle";
	int fee = 0;

	public String getDescription() {
		return description;
	}

	public abstract int cost();
}
