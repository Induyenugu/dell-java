
public class Tool implements IRentable{
	
	private double hourlyRate;
	private String description;
	
	/**
	 * Constructor that takes 2 parameters
	 * @param description
	 * @param hourlyRate
	 */
	public Tool(String description, double hourlyRate)
	{
		this.description=description;
		this.hourlyRate=hourlyRate;
	}
	
	/**
	 * @return the description of the item
	 */
	@Override
	public String getDescription()
	{
		return description + " is great and serves your purpose";
	}
	
	/**
	 * @return the daily rate for renting the item
	 */
	@Override
	public double getDailyRate()
	{
		return (double) Math.round((hourlyRate*24) * 100) / 100 ;	
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
