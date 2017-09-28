package Week4.drills;

import java.util.Scanner;

public class drill4 {
	public static void main(String[] args) {
		
		//"display to 2 decimal places"
		//do it and get marked down. fuck sake
		double Input1, Input2, Input3, average;
		String result;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ass 1 score: ");
		Input1 = scan.nextDouble();
		
		System.out.println("Ass 2 score: ");
		Input2 = scan.nextDouble();
		
		System.out.println("Ass 3 score: ");
		Input3 = scan.nextDouble();
		
		average = (Input1 + Input2 + Input3) / 3;
		
		if (average == (long) average)
		{
			result = String.format("%d", (long)average);
		}
		else
		{
			result = String.format("%.2f", average);
		}

		
		System.out.println("Your average score is " + result);
	}
}
