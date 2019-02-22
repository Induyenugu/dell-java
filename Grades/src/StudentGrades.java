import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class StudentGrades {

	private static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Welcome note to user about Student grades program
		System.out.println("Welcome to Student grades program");
		System.out.println("It provides list of 10 students and their 5 grades and also gives average student grade for each student");
		
		//Take input from User
		System.out.println("PLease enter no of students in your class");
		
		int input = 	CheckValidInput(reader.nextLine());	
		
		//Generates 10 students with 5 random grades
		Map<String, String[]> studentandGrades= new HashMap<>();		
		  
        for (int i = 0; i < input; i++) 
        {
        	System.out.println("Enter Student " + (i+1) +" Name");        	
        	String studentid= reader.nextLine();
        	System.out.println("Enter Student " + studentid+ " grades");   
        	String[] studentgrades= reader.nextLine().split(",");
        	studentandGrades.put(studentid, studentgrades);
        }   
        reader.close();
        
        //Calculates and prints average grade of each student
        StudentsAvgGrade(studentandGrades);
        
    	
	}
	
	//Verifies for valid inout from user
	
	private static int CheckValidInput(String input) {
		int validinput=0;
		try
		{
			validinput= Integer.parseInt(input);
			if(validinput<=0)
			{
				System.out.println("PLease enter a valid number");			
				CheckValidInput(reader.nextLine());	
			}
		}
		catch(Exception ex)
		{
			System.out.println("PLease enter a valid number");			
			CheckValidInput(reader.nextLine());	
		}
		return validinput;
	}
	
	/*
	 * Calculates and returns average grade for a given set of grades
	 */
	
	private static double averageGrade(String[] grades)
	{
		double avgGrade=0;
		for(String grade: grades)
		{
			avgGrade= avgGrade+ grade==null?0: Double.parseDouble(grade);
		}
		
		return avgGrade/(double)grades.length;
	}
	
	/*
	 * This method takes list of students and their grades and iterates through each student and prints the average grade he got
	 */
	
	private static Map<String, Double> StudentsAvgGrade(Map<String, String[]> studentandGrades)
	{
		Map<String, Double> StudentavgGrades= new HashMap<>();
		for(Map.Entry<String, String[]> entry: studentandGrades.entrySet())
		{
			String studentId=entry.getKey();
			Double avgGrade=averageGrade(entry.getValue());
			StudentavgGrades.put(studentId,avgGrade );
			System.out.println("The Average Grade for Student: "+ studentId +" is " + avgGrade);
			
		}
		return StudentavgGrades;
		
	}

}
