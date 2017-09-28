package Week3;

import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		String first, second;
		int Number;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a line: ");
		first = scan.nextLine();
		
		System.out.println("Enter another line: ");
		second = scan.nextLine();
		
		Number = Integer.parseInt(first + second);
		
		System.out.println("Number = " + (Number+1));
		
	}
}
