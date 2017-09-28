package Week3;

import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		
		int Input, valid = 0;
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.print("Enter an amount of cents in the range 0 to 100: ");
			Input = scan.nextInt();	
			if (Input >= 0 && Input <= 100) valid = 1; 
			else System.out.print("Invalid Input\nEnter an amount of cents in the range of 0 to 100: ");
		} while (valid == 0);
			//1: Divide by 20 to get 20c. 2: Remainder of Input/20 divided by 5 for five cent pieces. 3: Remainder of Input/20/5 for 1c coins. 
		System.out.println("Dispensing...\n" + Input/20 + " 20c coin(s)\n" + Input%20/5 + " 5c coin(s)\n" + Input%20%5/1 + " 1c coin(s)");
	}

}
