public class ParkingGarage
	{
	
	/**
	 * placeholder for all class variables
	 * */
	
		private static Car[] cars;
		private int maxCapacity;
		private int currentCapacity=0;
		private String garageName;
		
		/** Constructor that takes capacity and garageName
		 * @param capacity
		 * @param garageName
		 */
		public ParkingGarage(int capacity, String garageName)
		{
			maxCapacity=capacity;
			cars= new Car[maxCapacity];
			this.garageName=garageName;
		}
		
		
		/** Parks a given car in the spot based on the availability of spot
		 * @param car
		 * @param spot
		 */
		public void Park(Car car, int spot)
		{
			if(currentCapacity>=maxCapacity)
			{
				System.out.println("Already reached max capacity of " + currentCapacity);
				return;
			}
			if(spot>=maxCapacity || spot<0)
			{
				System.out.println("THe spot entered: "+spot+" is either greaterthan or equal to "+maxCapacity+" or less than 0");
				return;
			}
			if(cars[spot]==null)
			{	
				cars[spot]= car;
				currentCapacity++;
				System.out.println("The car is added to parking spot "+spot+" in "+garageName);				

			}
				
			
		}
		
		/**
		 * Vacates the car in the given spot
		 * @param spot
		 */
		public void VacateCar(int spot)
		{
			if(currentCapacity<=0)
			{
				System.out.println("The Garage "+ this.garageName+ " is empty");
				return;
			}
			if(spot>=maxCapacity || spot<0)
			{
				System.out.println("The spot " +spot+" is either greater than or equal to max capacity:" +maxCapacity+" or less than 0");
				return;
			}
			if(cars[spot]!=null)
			{
				cars[spot]= null;
				currentCapacity--;
				System.out.println("The car is removed parking spot "+spot+" in "+garageName);
			}
		}
		
		
		/**
		 * Prints the current inventory
		 */
		public void PrintInventory()
		{
			if(currentCapacity<=0)
			{
				System.out.println("The current inventory is empty for "+ garageName);
				return;
			}
			else
			{
				System.out.println("The current garage "+ garageName + " is filled with " +currentCapacity+" cars");
				
				for(Car car:cars)
				{
					if(car!=null)
					{
						System.out.println("The car with color "+car.getColor()+", licese "+car.getLicense()+", make "+car.getMake()+", and model "+car.getModel()+" is parked in the garage");
					}
				}
			}
		}
	}