package bundlemanagement.pac;

import bundlemanagement.preconf.*;
import bundlemanagement.component.*;
import bundlemanagement.service.*;

public class SimplePacBundleWithCallingFactory implements SimpleBundleFactory {
	public Bundle createBundle(BundleOption option) {
		PaCBundle pac = new BareBonePhoneService();

		switch (option) {
			case PAC_WITH_PLATINUM_CALLING:
				pac = new PlatinumCallingPlan(pac);
				break;
			case PAC_WITH_GOLD_CALLING:
				pac = new GoldCallingPlan(pac);
				break;
			case PAC_WITH_SILVER_CALLING:
				pac = new SilverCallingPlan(pac);
				break;
			case PAC_WITH_BRONZE_CALLING:
				pac = new BronzeCallingPlan(pac);
				break;
			default:
				System.out.println("Sorry, we don't have this calling option.");
				break;
		}

		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");	
		return pac;
	}
}
