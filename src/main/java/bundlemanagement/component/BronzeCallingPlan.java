package bundlemanagement.component;

import bundlemanagement.pac.*;
import bundlemanagement.preconf.*;

public class BronzeCallingPlan extends BundleDecorator implements CallingPlan {

	PaCBundle pacbundle;
	private static final int BRONZE_CALLING_MINUTES = 30;
	private static final int BRONZE_CALLING_PLAN_FEE = 15;
	private static final String BRONZE_CALLING_DESCRIPTION = "Bronze: 30 min free Canada wide calling";

	// This constructor use for Preconfigured Bundle side.
	public BronzeCallingPlan() {
	}

	// This constructor use for PaC Bundle side.
	public BronzeCallingPlan(PaCBundle pacbundle) {
		this.pacbundle = pacbundle;
	}

	// This method use for PaC side.
	@Override
	public String getDescription() {
		return pacbundle.getDescription() + BRONZE_CALLING_DESCRIPTION + "\n";
	}

	// This method use for PaC side.
	@Override
	public int cost() {
		return pacbundle.cost() + BRONZE_CALLING_PLAN_FEE;
	}

	// This Method use for Preconf side.
	public String toString() {
		return "30 min free Canada wide calling";
	}

	public int getCallingMinutes() {
		return BRONZE_CALLING_MINUTES;
	}

}
