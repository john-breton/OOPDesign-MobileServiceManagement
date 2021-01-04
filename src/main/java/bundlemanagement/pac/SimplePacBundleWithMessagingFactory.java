package bundlemanagement.pac;

import bundlemanagement.component.*;
import bundlemanagement.preconf.Bundle;
import bundlemanagement.service.*;

public class SimplePacBundleWithMessagingFactory implements SimpleBundleFactory {

	public Bundle createBundle(BundleOption option) {
		PaCBundle pac = new BareBonePhoneService();
		switch (option) {
			case PACWITHPLATINUMMESSAGING:
				pac = new PlatinumMessagingPlan(pac);
				break;
			case PACWITHGOLDMESSAGING:
				pac = new GoldMessagingPlan(pac);
				break;
			case PACWITHSILVERMESSAGING:
				pac = new SilverMessagingPlan(pac);
				break;
			case PACWITHBRONZEMESSAGING:
				pac = new BronzeMessagingPlan(pac);
				break;
			default:
				System.out.println("Sorry, we don't have this messaging option.");
		}

		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}

}
