package bundlemanagement.pac;
import bundlemanagement.preconf.*;
import bundlemanagement.component.*;

import bundlemanagement.service.SimpleBundleFactory;

public class SimplePacBundleWithCallingFactory implements SimpleBundleFactory {
	public Bundle createBundle(String name) {
		PaCBundle pac = new BareBonePhoneService();
		if (name.equals("PacWithPlatinumCalling")) {
			pac = new PlatinumCallingPlan(pac);
		} else if (name.equals("PacWithGoldCalling")) {
			pac = new GoldCallingPlan(pac);
		} else if (name.equals("PacWithSilverCalling")) {
			pac = new SilverCallingPlan(pac);
		} else if (name.equals("PacWithBronzeCalling")) {
			pac = new BronzeCallingPlan(pac);
		} else {
			System.out.println("Sorry, we don't have this calling option.");
		}
		System.out.println("Your Plan:\n" + pac.getDescription() + "total amount $" + pac.cost() + "\n");
		return pac;
	}
}
