import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		System.out.println("Hi this is a simple calcultaor program");
		//Take inputs from the user
		System.out.println("Please type first number");
		Scanner reader = new Scanner(System.in);
		String input1 = reader.nextLine();	
		System.out.println("Please type second number");
		String input2 = reader.nextLine();	
		
		//convert the string into double
		double num1=Double.parseDouble(input1);
		double num2=Double.parseDouble(input2);	
		
		//Print Sum, difference, product, quotient
		System.out.println("Sum of numbers is "+Add(num1, num2));
		System.out.println("Difference of numbers is "+Difference(num1, num2));
		System.out.println("product of numbers is "+Multiply(num1, num2));
		System.out.println("Quotient of numbers is "+Quotient(num1, num2));		
		reader.close();
	}
	
	/*
	 * Takes 2 numbers returns sum of them
	 */
	private  static String Add(double num1, double num2)
	{
		return Double.toString(num1+num2);
	}	
	
	/*
	 * Takes 2 numbers returns sum of them
	 */
	private static String Difference(double num1, double num2)
	{
		return Double.toString(num1-num2);
	}
	
	/*
	 * Takes 2 numbers returns multiply them
	 */
	private static String Multiply(double num1, double num2)
	{
		return Double.toString(num1*num2);
	}
	
	/*
	 * Takes 2 numbers returns quotient of them
	 */
	private static String Quotient(double num1, double num2)
	{
		return Double.toString(num1/num2);
	}
	


}
