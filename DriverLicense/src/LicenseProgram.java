import java.time.LocalDate;


public class LicenseProgram {

	public static void main(String[] args) 
	{
		//Create 3 license instances
		
		LocalDate dob1= LocalDate.of(1990,9, 9);
		DriversLicense license1= new DriversLicense("Indu", "Yenugu", dob1, (double)6.1,"Female");		
		
		LocalDate dob2= LocalDate.of(1992,2, 2);
		DriversLicense license2= new DriversLicense("Kishore", "Vanka", dob2, (double)6.8,"Male");
		
		LocalDate dob3= LocalDate.of(2012,11,26);
		DriversLicense license3= new DriversLicense("Charit", "Vanka", dob3, (double)4.6,"Male");
		
		//Add 3 license instance in Driving license array of 3
		DriversLicense[] licenses= new DriversLicense[3];
		licenses[0]=license1;
		licenses[1]=license2;
		licenses[2]=license3;
		
		//loops through each license instance and print full name and Age
		for(DriversLicense license: licenses )
		{		
		System.out.println("The name of the person is "+ license.GetName());
		System.out.println("The age of the person " + license.GetName() +" is " + license.GetAge());
		}
		
	}

}
