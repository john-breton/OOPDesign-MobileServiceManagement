package bundlemanagement.pac;

import bundlemanagement.component.*;
import bundlemanagement.preconf.Bundle;
import bundlemanagement.service.*;

public class SimplePacBundleWithMessagingFactory implements SimpleBundleFactory {

	public Bundle createBundle(BundleOption option) {
		PaCBundle pac = new BareBonePhoneService();
		switch (option) {
			case PAC_WITH_PLATINUM_MESSAGING:
				pac = new PlatinumMessagingPlan(pac);
				break;
			case PAC_WITH_GOLD_MESSAGING:
				pac = new GoldMessagingPlan(pac);
				break;
			case PAC_WITH_SILVER_MESSAGING:
				pac = new SilverMessagingPlan(pac);
				break;
			case PAC_WITH_BRONZE_MESSAGING:
				pac = new BronzeMessagingPlan(pac);
				break;
			default:
				System.out.println("Sorry, we don't have this messaging option.");
		}

		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}

}
