package bundlemanagement.preconf;

public enum DataPlanOptions {

	/**
	 * Data Plan Options
	 */
	PLATINUM("10 GB"), GOLD("4 GB"),
	SILVER("2 GB"), BRONZE("1 GB"), Zero("0 GB");

	/**
	 * The dataPlanOptionDescription will store the description for related
	 * data plan.
	 */
	private String dataPlanOptionDescription;

	/**
	 * A constructor to invoke proper enum data option
	 * 
	 * @param type it will store the related plan description into
	 *             dataPlanOptionDescription.
	 */
	private DataPlanOptions(String type) {
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

}
