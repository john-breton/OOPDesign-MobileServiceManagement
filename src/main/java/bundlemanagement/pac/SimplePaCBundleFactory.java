package bundlemanagement.pac;
import bundlemanagement.component.*;
import bundlemanagement.service.BundleOption;

public class SimplePaCBundleFactory {
	public PaCBundle createBundle(String name, BundleOption CallingOption, BundleOption MessagingOption, BundleOption DataOption) {
		PaCBundle pac = new BareBonePhoneService();
		
		if(CallingOption != null) {
			switch(CallingOption) {
			case PLATINUM:
				pac = new PlatinumCallingPlan(pac);
				break;
			case GOLD:
				pac = new GoldCallingPlan(pac);
				break;
			case SILVER:
				pac = new SilverCallingPlan(pac);
				break;
			case BRONZE:
				pac = new BronzeCallingPlan(pac);
				break;
			case ZERO:
				pac = new ZeroCallingPlan(pac);
				break;
			}
		}
		if(MessagingOption != null) {
			switch(MessagingOption) {
			case PLATINUM:
				pac = new PlatinumMessagingPlan(pac);
				break;
			case GOLD:
				pac = new GoldMessagingPlan(pac);
				break;
			case SILVER:
				pac = new SilverMessagingPlan(pac);
				break;
			case BRONZE:
				pac = new BronzeMessagingPlan(pac);
				break;
			case ZERO:
				pac = new ZeroMessagingPlan(pac);
				break;
			}		
		}
		if(DataOption != null) {
			switch(DataOption) {
			case PLATINUM:
				pac = new PlatinumDataPlan(pac);
				break;
			case GOLD:
				pac = new GoldDataPlan(pac);
				break;
			case SILVER:
				pac = new SilverDataPlan(pac);
				break;
			case BRONZE:
				pac = new BronzeDataPlan(pac);
				break;
			case ZERO:
				pac = new ZeroDataPlan(pac);
				break;
			}		
		}
		pac.setName(name);
		return pac;
		
	}

}
