package Week4;

import java.util.Scanner;
import java.util.Random;
public class Task2 {
	public static void main(String[] args) {
		
		Random rand = new Random();
		int Input, random = rand.nextInt((10 - 1) + 1) + 1, valid = 0, option;
		String equation = "";
		Scanner scan = new Scanner(System.in);

		do
		{
		System.out.print("Enter a number between 0 and 10: ");
		Input = scan.nextInt();
		
		if(Input >= 0 && Input <= 10) valid = 1;
		else System.out.println("Invalid Input.");
		
		} while (valid == 0);
		valid = 0; //reset valid check
		//System.out.println(Input + " " + random);
		
		//Operator Menu 
		
		do
		{
			System.out.println("Input an option\n1 - Add\n2 - Subtract\n3 - Multiply\n4 - Divide");
			option = scan.nextInt();
			if (option >=1 && option <= 4) valid = 1;
			else System.out.println("Invalid option.");
			
		} while (valid == 0);
		
		switch (option)
		{
		case 1: //Add
			equation = Input + " + " + random + " = " + (int)(Input+random);
			break;
		case 2: //Subtract
			equation = random + " - " + Input + " = " + (int)(random-Input);
			break;
		case 3: //Multiply
			equation = Input + " * " + random + " = " + (int)(Input*random);
			break;
		case 4: //Divide
			equation = Input + " / " + random + " = " + (int)(Input/random);
			break;
		}
		
		//output
		System.out.println(equation);
		
	}
}
