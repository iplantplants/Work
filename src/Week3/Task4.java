package Week3;

import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {
		int Input;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		Input = scan.nextInt();
		
		System.out.println(Input/10.0 + "\n" + Input%10/10.0 + "\n" + Input%10 + "\n" + Input/10);
	}
}
