
public interface IRentable {
	
	/**
	 * @return the description of the item
	 */
	public String getDescription();
	
	/**
	 * @return the daily rate for renting the item
	 */
	public double getDailyRate();
	
	/**
	 * @returns the amount due for renting the item for the a given number of days
	 */
	public double getPrice(double days);
}
