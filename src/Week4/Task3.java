package Week4;

import java.util.Scanner;
public class Task3 {
	public static void main(String[] args) {
		
		int Input;
		String state = "positive", even = "odd";
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		Input = scan.nextInt();
		
		if (Input < 0) state = "negative";
		if (Input == 0) state = "zero";
		if (Input%2 == 0) even = "even";
		System.out.println(Input + " is " + state + ".\nIt is " + even + ".");	
		
	}
}
