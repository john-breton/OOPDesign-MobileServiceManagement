package bundlemanagement.pac;

import bundlemanagement.component.*;
import bundlemanagement.preconf.Bundle;
import bundlemanagement.service.SimpleBundleFactory;

public class SimplePacBundleWithDataFactory implements SimpleBundleFactory {

	public Bundle createBundle(String name) {
		PaCBundle pac = new BareBonePhoneService();
		if (name.equals("PacWithPlatinumData")) {
			pac = new PlatinumDataPlan(pac);
		} else if (name.equals("PacWithGoldData")) {
			pac = new GoldDataPlan(pac);
		} else if (name.equals("PacWithSilverData")) {
			pac = new SilverDataPlan(pac);
		} else if (name.equals("PacWithBronzeData")) {
			pac = new BronzeDataPlan(pac);
		} else {
			System.out.println("Sorry, we don't have this data option.");
		}
		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}

}
