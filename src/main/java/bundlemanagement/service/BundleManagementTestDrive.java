package bundlemanagement.service;

import reportingservice.ConcreteReportingService;

public class BundleManagementTestDrive {

	public static void main(String[] args) {
        ConcreteReportingService reportingService = ConcreteReportingService.getInstance();
		BundleManagement bundleManagement = BundleManagement.getInstance();
		
        reportingService.addPropertyChangeListener(bundleManagement);
        bundleManagement.addPropertyChangeListener(reportingService);

		bundleManagement.addPreconfBundle("Yangrui's Bundle", BundleOption.GOLD);
		bundleManagement.addPreconfBundle("Anna's Bundle", BundleOption.PLATINUM);
		bundleManagement.addPaCBundle("Dave's Bundle", BundleOption.BRONZE, BundleOption.ZERO, null);
		bundleManagement.addPaCBundle("Pat's Bundle", BundleOption.SILVER, null, BundleOption.GOLD);
		bundleManagement.addPreconfBundle("Yangrui's Bundle", BundleOption.GOLD);
		bundleManagement.addPaCBundle("Dave's Bundle", BundleOption.BRONZE, BundleOption.ZERO, null);
		
		//Test for private method
		//bundleManagement.listBundleDetail("Yangrui's Bundle");
		//bundleManagement.listBundleDetail("xx's Bundle");
		//bundleManagement.listAllPacBundles();
		//bundleManagement.listAllPreconfBundles();
		
	}

}

/**Test output:
 * ---Bundle Detail---
Name: Yangrui's Bundle
Calling Plan: Unlimited Canada wide calling
Messaging Plan: 10K Messages
Data Plan: 4 GB
Monthly Fee: 80$


---Bundle Detail---
Name: Anna's Bundle
Calling Plan: Unlimited US & Canada wide calling
Messaging Plan: Unlimited Messages
Data Plan: 10 GB
Monthly Fee: $100


---Bundle Detail---
Name: Dave's Bundle
Bare Bone Phone Service
Calling Plan: Bronze - 30 min free Canada wide calling
Messaging Plan: Zero - Zero Messages
Monthly Fee: $25

---Bundle Detail---
Name: Pat's Bundle
Bare Bone Phone Service
Calling Plan: Silver - 100 min free Canada wide calling
Data Plan: Gold - Data Included: 7 GB
Monthly Fee: $60

Failed to add a new bundle. The bundle name "Yangrui's Bundle" is already used by another bundle.

Failed to add a new bundle. The bundle name "Dave's Bundle" is already used by another bundle.

---Bundle Detail---
Name: Yangrui's Bundle
Calling Plan: Unlimited Canada wide calling
Messaging Plan: 10K Messages
Data Plan: 4 GB
Monthly Fee: $80

No Bundle with the name "xx's Bundle" was found.

---PaC Bundles---
Pat's Bundle
Dave's Bundle

---Preconfigured Bundles---
Anna's Bundle
Yangrui's Bundle*/
