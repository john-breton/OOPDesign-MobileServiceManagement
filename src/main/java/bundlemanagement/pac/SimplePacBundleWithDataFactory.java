package bundlemanagement.pac;

import bundlemanagement.component.*;
import bundlemanagement.preconf.Bundle;
import bundlemanagement.service.*;

public class SimplePacBundleWithDataFactory implements SimpleBundleFactory {

	public Bundle createBundle(BundleOption option) {
		PaCBundle pac = new BareBonePhoneService();
		switch (option) {
		case PACWITHPLATINUMDATA:
			pac = new PlatinumDataPlan(pac);
			break;
		case PACWITHGOLDDATA:
			pac = new GoldDataPlan(pac);
			break;
		case PACWITHSILVERDATA:
			pac = new SilverDataPlan(pac);
			break;
		case PACWITHBRONZEDATA:
			pac = new BronzeDataPlan(pac);
			break;
		default:
			System.out.println("Sorry, we don't have this data option.");
		}

		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}

}
