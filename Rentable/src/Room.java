
public class Room implements IRentable {

	private double dailyRate;
	private String description;
	
	/**
	 * Constructor that takes 2 parameters
	 * @param description
	 * @param dailyRate
	 */
	public Room(String description, double dailyRate)
	{
		this.description=description;
		this.dailyRate=dailyRate;
	}
	
	/**
	 * @return the description of the item
	 */
	@Override
	public String getDescription()
	{
		return description + " with great view including all amenities";
	}
	
	/**
	 * @return the daily rate for renting the item
	 */
	@Override
	public double getDailyRate()
	{
		return dailyRate;
	}
	
	/**
	 * @returns the amount due for renting the item for the a given number of days
	 */
	@Override
	public double getPrice(double days)
	{
		return (double) Math.round((days*getDailyRate()) * 100) / 100 ;
	}
	
}
