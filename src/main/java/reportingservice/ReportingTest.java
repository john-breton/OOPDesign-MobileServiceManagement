package reportingservice;

/**
 * This is just a simple test to check that the ConcreteReportingService and
 * ManagementReportingServiceTemplate are working properly
 * 
 * @author Matthew Siu
 * @version December 31, 2020
 * @since December 30, 2020
 */
public class ReportingTest {

	/**
	 * expected result:
	 * 
	 * creating new account 
	 * Here's some important information!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConcreteReportingService reportingService = ConcreteReportingService.getInstance();
		ManagementReportingServiceTemplate managementService = ManagementReportingServiceTemplate.getInstance();

		reportingService.addPropertyChangeListener(managementService);
		managementService.addPropertyChangeListener(reportingService);

		managementService.createAccount();

	}

}
