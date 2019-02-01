import java.time.LocalDate;
import java.time.Period;

	/**
	 * @author Indumathi_Yenugu
	 *
	 */
	public class DriversLicense
	{
		//place holder for all class variables
		private String fName;
		private String lName;
		private LocalDate birthDate;
		private String gender;
		private double height;
		
		
		/**
		 * constructor that takes below parameters
		 * @param firstName
		 * @param lastName
		 * @param birthdate
		 * @param height
		 * @param gender
		 */
		public DriversLicense(String firstName, String lastName, LocalDate birthdate, double height, String gender)
		{
			fName=firstName;
			lName=lastName;
			this.birthDate=birthdate;
			this.height=height;
			this.gender=gender;
		}
		
		
		/**
		 * @returns the Full name of the person
		 */
		public String GetName()
		{
			return fName+" "+lName;
		}
		
		/**
		 * @returns the age of the person
		 */
		public int GetAge()
		{
			LocalDate currentDate = LocalDate.now();			
			return Period.between(birthDate, currentDate).getYears();
		}
	}
