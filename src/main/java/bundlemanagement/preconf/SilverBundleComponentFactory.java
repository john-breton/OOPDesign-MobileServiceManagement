package bundlemanagement.preconf;
import bundlemanagement.component.*;

public class SilverBundleComponentFactory implements BundleComponentFactory{

	public CallingPlan createCallingPlan() {
		// TODO Auto-generated method stub
		return new SilverCallingPLan();
	}

	
	public MessagingPlan createMessagingPlan() {
		// TODO Auto-generated method stub
		return new SilverMessagingPLan();
	}


	public DataPlan createDataPaln() {
		// TODO Auto-generated method stub
		return new SilverDataPLan();
	}

	
	public MonthlyFees createMonthlyFees() {
		// TODO Auto-generated method stub
		return new SilverMonthlyFees();
	}

}
