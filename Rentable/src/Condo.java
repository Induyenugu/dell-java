
public class Condo implements IRentable{
	
	private double weeklyRate;
	private String description;
	
	
	/**
	 * Constructor that takes 2 parameters
	 * @param description
	 * @param weeklyRate
	 */
	public Condo(String description, double weeklyRate)
	{
		this.description=description;
		this.weeklyRate=weeklyRate;
	}
	
	/**
	 * @return the description of the item
	 */
	@Override
	public String getDescription()
	{
		return description + " in a great neighbourhood with good school district";
	}
	
	/**
	 * @return the daily rate for renting the item
	 */
	@Override
	public double getDailyRate()
	{
		return (double) Math.round((weeklyRate/7) * 100) / 100 ;		
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
