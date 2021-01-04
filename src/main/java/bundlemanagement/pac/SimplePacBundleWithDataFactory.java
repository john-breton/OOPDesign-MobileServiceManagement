package bundlemanagement.pac;

import bundlemanagement.component.*;
import bundlemanagement.preconf.Bundle;
import bundlemanagement.service.*;

public class SimplePacBundleWithDataFactory implements SimpleBundleFactory {

	public Bundle createBundle(BundleOption option) {
		PaCBundle pac = new BareBonePhoneService();
		switch (option) {
		case PAC_WITH_PLATINUM_DATA:
			pac = new PlatinumDataPlan(pac);
			break;
		case PAC_WITH_GOLD_DATA:
			pac = new GoldDataPlan(pac);
			break;
		case PAC_WITH_SILVER_DATA:
			pac = new SilverDataPlan(pac);
			break;
		case PAC_WITH_BRONZE_DATA:
			pac = new BronzeDataPlan(pac);
			break;
		default:
			System.out.println("Sorry, we don't have this data option.");
		}

		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}

}
