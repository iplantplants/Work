package Week3.drills;

import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		int Input;
		boolean numberGame;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a 3-digit integer");
		Input = scan.nextInt();
		
		if ((Input/100 + Input%100/10 + Input%100%10/1) < (Input/100) * (Input%100/10))
		{
			numberGame = true;
		}
		else
		{
			numberGame = false;
		}
		System.out.println("The number is " + numberGame);
		//System.out.println(Input/100 + " " + Input%100/10 + " " + Input%100%10/1);
		//System.out.println((Input/100 + Input%100/10 + Input%100%10/1) + " " + (Input/100) * (Input%100/10));
	}
}
