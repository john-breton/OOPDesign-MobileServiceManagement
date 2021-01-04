package bundlemanagement.pac;

import bundlemanagement.preconf.*;

public abstract class PaCBundle extends Bundle{
	String description = "Unknown plain and customized bundle";
	int fee = 0;

	public String getDescription() {
		return description;
	}

	public abstract int cost();
}
