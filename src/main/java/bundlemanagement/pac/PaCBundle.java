package bundlemanagement.pac;

public abstract class PaCBundle {
	String description= "Unknown pick and customized bundle";
	
	public String getDescription() 
	{
		return description;
	}
	
	public abstract int cost();
}
