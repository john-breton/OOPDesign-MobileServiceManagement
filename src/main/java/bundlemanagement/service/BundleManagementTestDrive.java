package bundlemanagement.service;

public class BundleManagementTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BundleManagement bundleManagement = BundleManagement.getBundleManagementInstance();

		bundleManagement.addPreconfBundle(BundleOption.GOLD);
		bundleManagement.addPlainPacBundle(BundleOption.PLAINPACBUNDLE);
		bundleManagement.addPacBundleWithCallingOption(BundleOption.PACWITHPLATINUMCALLING);
		bundleManagement.addPacBundleWithMessagingOpiton(BundleOption.PACWITHSILVERMESSAGING);
		bundleManagement.addPacBundleWithDataOpiton(BundleOption.PACWITHBRONZEDATA);
	}

}
