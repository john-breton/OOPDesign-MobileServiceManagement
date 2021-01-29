package bundlemanagement.preconf;

public enum DataPlanOptions {

	/**
	 * Data Plan Options
	 */
	PLATINUM("Platinum Data Plan", "10 GB"),
	GOLD("Gold Data Plan", "4 GB"),
	SILVER("Silver Data Plan", "2 GB"),
	BRONZE("Bronze Data Plan", "1 GB"),
	ZERO("Zero Data Plan", "0 GB");

	/**
	 * The dataPlanOptionDescription will store the description for related
	 * data plan.
	 */
	private String dataPlanOptionDescription;
	private String name;

	/**
	 * A constructor to invoke proper enum data option
	 * 
	 * @param name  it will store the name of data plan
	 * @param type  it will store the related plan description into
	 *              dataPlanOptionDescription.
	 */
	DataPlanOptions(String name, String type) {
		this.name = name;
		this.dataPlanOptionDescription = type;
	}

	/**
	 * It will return description for the invoked data option.
	 * 
	 * @return dataPlanOptionDescription
	 */
	String getdDataPlanOptionsDesription() {
		return dataPlanOptionDescription;
	}
	
	/**
	 * It will return name for the invoked data option.
	 * 
	 * @return name of the data plan
	 */
	String getdDataPlanName() {
		return name;
	}	

}
