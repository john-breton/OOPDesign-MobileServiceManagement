package bundlemanagement.service;

import reportingservice.ReportingService;

public class BundleManagementTestDrive {

	public static void main(String[] args) {
		ReportingService reportingService = ReportingService.getInstance();
		BundleManagement bundleManagement = BundleManagement.getInstance();

		reportingService.addPropertyChangeListener(bundleManagement);
		bundleManagement.addPropertyChangeListener(reportingService);
		
		System.out.println("\n>>>Adding two preconfigured bundles<<<");
		bundleManagement.addPreconfBundle("GOLD");
		bundleManagement.addPreconfBundle("PLATINUM");
		bundleManagement.addPreconfBundle("BRONZE");
		/*output:
				New Bundle Added:
				---Bundle Detail---
				Bundle Name: Gold Preconfigured Bundle
				Calling Plan: Unlimited Canada wide calling
				Messaging Plan: 10K Messages
				Data Plan: 4 GB
				Monthly Fee: $80
				
				New Bundle Added:
				---Bundle Detail---
				Bundle Name: Platinum Preconfigured Bundle
				Calling Plan: Unlimited US & Canada wide calling
				Messaging Plan: Unlimited Messages
				Data Plan: 10 GB
				Monthly Fee: $100
				
				New Bundle Added:
				---Bundle Detail---
				Bundle Name: Bronze Preconfigured Bundle
				Calling Plan: 30 min free Canada wide calling
				Messaging Plan: 250 Messages
				Data Plan: 1 GB
				Monthly Fee: $25
				*/
		
		//test addPreconfBundle() method for adding invalid name
		System.out.println("\n>>>Adding a preconfigured bundle with invalid name<<<");
		bundleManagement.addPreconfBundle("Yangrui's bundle");
		/*output:
			Invalid Bundle Name*/
		bundleManagement.addPreconfBundle("PACWITHBRONZECALLING");
		/*output:
		 * Sorry, we only take order for "PLATINUM", "GOLD", "SILVER", "BRONZE" Preconfigured Bundle in this option*/
		
		System.out.println("\n>>>Adding a Plain PaC Bundle<<<");
		bundleManagement.addPlainPacBundle("PLAINPACBUNDLE");
		/*output
		 * New Bundle Added:
			---Bundle Detail---
			Bundle Name: Plain Pick and Choose Bundle
			Bare Bone Phone Service
			PaC Calling Plan: Not Choose  <---required by Ista. Show customer did not choose this plan option
			PaC Messaging Plan: Not Choose
			PaC Data Plan: Not Choose
			Monthly Fee: $10*/
		
		//test addPlainPacBundle for invalid name
		System.out.println("\n>>>Adding a Plain PaC Bundle withi invalid name<<<");
		bundleManagement.addPlainPacBundle("PACWITHGOLDCALLING");
		/*output: Sorry, we only take order for "PLAINPACBUNDLE" in this option*/
		
		System.out.println("\n>>>Adding a PaC Bundle withi Calling option<<<");
		bundleManagement.addPacBundleWithCalling("PACWITHGOLDCALLING");
		/*output:
		 * New Bundle Added:
			---Bundle Detail---
			Bundle Name: Pick and Choose Bundle with Gold Calling Plan
			Bare Bone Phone Service
			Gold Calling Plan: Unlimited Canada wide calling
			PaC Messaging Plan: Not Choose
			PaC Data Plan: Not Choose
			Monthly Fee: $40*/
		
		//test addPacBundleWithCalling by adding invalid name
		System.out.println("\n>>>Adding a PaC Bundle withi Calling option using invalid name<<<");
		bundleManagement.addPacBundleWithCalling("PACWITHGOLDMESSAGING");
		/*output: Sorry, we only take order for PaC Bundle with Calling Plan in this option*/
		
		System.out.println("\n>>>Adding a PaC Bundle with Messaging option<<<");
		bundleManagement.addPacBundleWithMessaging("PACWITHSILVERMESSAGING");
		/*output:
		 * New Bundle Added:
			---Bundle Detail---
			Bundle Name: Pick and Choose Bundle with Silver Messaging Plan
			Bare Bone Phone Service
			PaC Calling Plan: Not Choose
			Silver Messaging Plan: 5K Messages
			PaC Data Plan: Not Choose
			Monthly Fee: $35*/
		
		//test addPacBundleWithMessaging() method with invalid name
		System.out.println("\n>>>Adding a PaC Bundle with Messaging option using invalid name<<<");
		bundleManagement.addPacBundleWithMessaging("PACWITHGOLDDATA");
		//Sorry, we only take order for PaC Bundle with Messaging Plan in this option
		
		//test to add a bundle that already exist in bundle list, it should still show a new bundle is created
		//but there will be only on GOLD preconfigured bundle in bundle List 
		//-- see the list all preconfBundle result below
		System.out.println("\n>>>Adding a preconfigured bundles that already exist<<<");
		bundleManagement.addPreconfBundle("GOLD");
		bundleManagement.addPacBundleWithCalling("PACWITHGOLDCALLING");

		System.out.println("\n>>>List exist bundle names<<<");
		bundleManagement.listAllPacBundles();
		bundleManagement.listAllPreconfBundles();
		/*output:
		 * ---PaC Bundles---
		Pick and Choose Bundle with Gold Calling Plan <---only one pac with gold calling in the system even it has been ordered twice
		Pick and Choose Bundle with Silver Messaging Plan
		Plain Pick and Choose Bundle
		
		---Preconfigured Bundles---
		Platinum Preconfigured Bundle
		Bronze Preconfigured Bundle
		Gold Preconfigured Bundle <---only one gold bundle in system even it has been ordered twice
		*/
		
		// Test for private method
		/*	
		public void printFee(String name) {
			support.firePropertyChange(BUNDLE + PROPERTY_CHANGE_SCOPE_DELIMITER + DISPLAY, name, Events.FEES.getDesc());
		}*/
		
		// System.out.println("\n>>>Print monthly fees<<<");
		// bundleManagement.printFee("GOLD");
		// bundleManagement.printFee("pacwithsilvermessaging");
		 /*---Monthly Fees---
		Bundle Name: Gold Preconfigured Bundle
		Monthly Fee: $80
		
		---Monthly Fees---
		Bundle Name: Pick and Choose Bundle with Silver Messaging Plan
		Monthly Fee: $35*/
		 

	}

}


