package Week4;

import java.util.Scanner;
public class Task1 {
	public static void main(String[] args) {
		
		double age;
		double ticket = 12;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter your age ");
		age = keyboard.nextDouble();
		
		if (age <= 8 || age >=65)
		{
			ticket = 6;
		}
		
		System.out.println("Your ticket costs $"+ticket);
		
	}
}
