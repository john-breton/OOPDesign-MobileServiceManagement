package bundlemanagement.pac;

public class BareBonePhoneService extends PaCBundle{
	
	public BareBonePhoneService() 
	{
		description="Bare Bone Phone Service";
	}

	@Override
	public int cost() {
		// return fixed flat rate
		return 10;
	}
	

}
