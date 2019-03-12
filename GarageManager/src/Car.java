public class Car
	{
	//place holder for all class variables
		private String color;
		private String license;
		private String make;
		private String model;		
		
		
		/** constructor that takes color, license, make and model
		 * @param color
		 * @param license
		 * @param make
		 * @param model
		 */
		public Car(String color, String license, String make, String model )
		{
			this.color=color;
			this.license=license;
			this.make=make;
			this.model=model;
		}
		
		
		/**
		 * @returns the color of the car
		 */
		public String getColor()
		{
			return color;
		}
		
		
		/**
		 * @returns the License
		 */
		public String getLicense()
		{
			return license;
		}
		
		/**
		 * @returns the Make of the car
		 */
		public String getMake()
		{
			return make;
		}
		
		/**
		 * @returns the Model of the Car
		 */
		public String getModel()
		{
			return model;
		}
	}