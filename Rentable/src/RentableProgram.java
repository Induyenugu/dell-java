
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Indumathi_Yenugu
 *
 */
	
public class RentableProgram {

	public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub				
		
		//Creates few room, Condo and tool instance with different rates
		Room room1= new Room("Deluxe Room",50);
		Room room2= new Room("Executive Room",75);
		Condo condo1= new Condo("Single Story Condo",100);
		Condo condo2= new Condo("Two Story Condo",120);
		Tool tool1= new Tool("EdgeCutter",5);
		Tool tool2= new Tool("Lawn Mover",10);
		
		
		//add all the instance into rentable array
		List<IRentable> rentableitems = new ArrayList<IRentable>();
		
		rentableitems.add(room1);
		rentableitems.add(room2);
		rentableitems.add(condo1);
		rentableitems.add(condo2);
		rentableitems.add(tool1);
		rentableitems.add(tool2);
		
		//Loop through each rentable item and print description, daily rate and ask user for no of days to rent and prints the price
		for(IRentable item: rentableitems)
		{
			System.out.println("Rentable item description is "+item.getDescription());
			System.out.println("Daily rate is  " + item.getDailyRate()+"$");
			double days= VerifyUserInput(item.getDescription());						
			System.out.println("Price to rent for " +days+ " is "+ item.getPrice(days) +"$");
			System.out.println("\n");
		}
		reader.close();	

	}
	
	
	/**
	 * @param itemdescription
	 * @returns the number days by converting string to double
	 */
	private static double VerifyUserInput(String itemdescription) {		
		double days=0;
		try
		{	
		System.out.println("Please enter number of days you want to rent ");		
		String userinput= reader.nextLine();
		days=Double.parseDouble(userinput);	
		return days;	
		
		}			
		catch(NumberFormatException  ex) 
		{
			System.out.println("You entered a non number");	
			days=VerifyUserInput(itemdescription);		
			
		}
		return days;
	
	}

}
