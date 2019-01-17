import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class StudentGrades {

	public static void main(String[] args) {
		
		//Welcome note to user about Student grades program
		System.out.println("Welcome to Student grades program");
		System.out.println("It provides list of 10 students and their 5 grades and also gives average student grade for each student");
		
		//Generates 10 students with 5 random grades
		Map<String, int[]> studentandGrades= new HashMap<>();		
		  
        for (int i = 0; i < 10; i++) 
        {
        	String studentid= "studentid-"+String.valueOf(i);
            int[] grades=generateRandomGrades();
            studentandGrades.put(studentid, grades); 
        	System.out.println("Added Student: "+ studentid +" and grades " + Arrays.toString(grades));
        }   
        
        //Calculates and prints average grade of each student
        StudentsAvgGrade(studentandGrades);
        

	}
	
	private static int[] generateRandomGrades()
	{
		int[] grades= new int[5]; 
		Random rand = new Random();
		 for (int i = 0; i < 5; i++)
		 {
			 int grade=rand.nextInt(100); 
			 grades[i]=grade;
		 }
		 return grades;
	        
	}
	
	/*
	 * Calculates and returns average grade for a given set of grades
	 */
	
	private static double averageGrade(int[] grades)
	{
		int avgGrade=0;
		for(int grade: grades)
		{
			avgGrade= avgGrade+grade;
		}
		
		return avgGrade/grades.length;
	}
	
	/*
	 * This method takes list of students and their grades and iterates through each student and prints the average grade he got
	 */
	
	private static Map<String, Double> StudentsAvgGrade(Map<String, int[]> studentandGrades)
	{
		Map<String, Double> StudentavgGrades= new HashMap<>();
		for(Map.Entry<String, int[]> entry: studentandGrades.entrySet())
		{
			String studentId=entry.getKey();
			Double avgGrade=averageGrade(entry.getValue());
			StudentavgGrades.put(studentId,avgGrade );
			System.out.println("The Average Grade for Student: "+ studentId +" is " + avgGrade);
			
		}
		return StudentavgGrades;
		
	}

}
