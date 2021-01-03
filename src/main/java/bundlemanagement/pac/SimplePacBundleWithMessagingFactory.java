package bundlemanagement.pac;

import bundlemanagement.component.*;
import bundlemanagement.preconf.Bundle;
import bundlemanagement.service.SimpleBundleFactory;

public class SimplePacBundleWithMessagingFactory implements SimpleBundleFactory {

	public Bundle createBundle(String name) {
		PaCBundle pac = new BareBonePhoneService();
		if (name.equals("PacWithPlatinumMessaging")) {
			pac = new PlatinumMessagingPlan(pac);
		} else if (name.equals("PacWithGoldMessaging")) {
			pac = new GoldMessagingPlan(pac);
		} else if (name.equals("PacWithSilverMessaging")) {
			pac = new SilverMessagingPlan(pac);
		} else if (name.equals("PacWithBronzeMessaging")) {
			pac = new BronzeMessagingPlan(pac);
		} else {
			System.out.println("Sorry, we don't have this messaging option.");
		}
		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}

}
