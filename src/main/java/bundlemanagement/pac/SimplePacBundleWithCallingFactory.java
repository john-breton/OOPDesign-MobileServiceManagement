package bundlemanagement.pac;

import bundlemanagement.preconf.*;
import bundlemanagement.component.*;
import bundlemanagement.service.*;

public class SimplePacBundleWithCallingFactory implements SimpleBundleFactory {
	public Bundle createBundle(BundleOption option) {
		PaCBundle pac = new BareBonePhoneService();

		switch (option) {
			case PACWITHPLATINUMCALLING:
				pac = new PlatinumCallingPlan(pac);
				break;
			case PACWITHGOLDCALLING:
				pac = new GoldCallingPlan(pac);
				break;
			case PACWITHSILVERCALLING:
				pac = new SilverCallingPlan(pac);
				break;
			case PACWITHBRONZECALLING:
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
