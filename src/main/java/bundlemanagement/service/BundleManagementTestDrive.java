package bundlemanagement.service;

public class BundleManagementTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BundleManagement bundleManagement = BundleManagement.getBundleManagementInstance();

		bundleManagement.addPreconfBundle("Gold");
		bundleManagement.addPlainPacBundle("PlainPacBundle");
		bundleManagement.addPacBundleWithCallingOption("PacWithPlatinumCalling");
		bundleManagement.addPacBundleWithMessagingOpiton("PacWithGoldMessaging");
		bundleManagement.addPacBundleWithDataOpiton("PacWithBronzeData");
	}

}
