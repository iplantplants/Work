package Week3;

import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		
		String first, second;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a line: ");
		first = scan.nextLine();
		
		System.out.println("Enter another line: ");
		second = scan.nextLine();
		
		System.out.println(second + ", " + first);
		
	}
}
