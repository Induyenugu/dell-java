import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Take array of numbers from user
		System.out.println("please enter number string with comma as delimeter");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();	
		
		//split the array to get list of numbers
		String[] inputArray=input.split(",");
		int[] numberArray= new int[inputArray.length];
		for(int i=0; i<inputArray.length; i++)
		{
			numberArray[i]=Integer.parseInt(inputArray[i]);
		}		
		
		System.out.println("Max number is "+ GetMaxNumber(numberArray));
		System.out.println("Min number is "+ GetMinNumber(numberArray));
		int sum=GetSumofNumbers(numberArray);
		System.out.println("Number of elements are "+ numberArray.length);
		System.out.println("the average is "+ GetAverage(sum, numberArray.length));
		System.out.println("the sum of numbers is "+sum);
		
		reader.close();
		
	}
	
	/*
	 * Gets the max number from a given number array
	 */
	public static int GetMaxNumber(int[] numberArray)
	{
		int max=numberArray[0];
		for(int i=1;i<numberArray.length-1; i++)
		{
			
			if(max<numberArray[i])
			{
				max=numberArray[i];
			}
	
		}
		return max;		
	}
	
	/*
	 * Gets the min number from a numberArray
	 */
	public static int GetMinNumber(int[] numberArray)
	{
		int min=numberArray[0];
		for(int i=1;i<numberArray.length-1; i++)
		{
			
			if(min>numberArray[i])
			{
				min=numberArray[i];
			}
	
		}
		return min;		
	}
	
	/*
	 * Get the sum of Numbers
	 */
	public static int GetSumofNumbers(int[] numberArray)
	{	
		int sum=numberArray[0];
		for(int i=1;i<numberArray.length-1; i++)
		{
			
			sum=sum+numberArray[i];
	
		}
		return sum;	
	}
	
	/*
	 * Get the average of the input array of numbers
	 */
	public static int GetAverage(int sum, int length)
	{
		return sum/length;	
	}
	
	


}
