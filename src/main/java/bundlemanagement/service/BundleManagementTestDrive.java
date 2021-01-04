package bundlemanagement.service;

public class BundleManagementTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BundleManagement bundleManagement = BundleManagement.getBundleManagementInstance();

		bundleManagement.addPreconfBundle(BundleOption.GOLD);
		bundleManagement.addPlainPacBundle(BundleOption.PLAIN_PAC_BUNDLE);
		bundleManagement.addPacBundleWithCallingOption(BundleOption.PAC_WITH_PLATINUM_CALLING);
		bundleManagement.addPacBundleWithMessagingOpiton(BundleOption.PAC_WITH_SILVER_MESSAGING);
		bundleManagement.addPacBundleWithDataOpiton(BundleOption.PAC_WITH_BRONZE_DATA);
	}

}
