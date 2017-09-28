package Week3.drills;

import java.util.Scanner;
public class Question4 {
	public static void main(String[] args) {
		int Input1, Input2;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter two integers:");
		
		Input1 = scan.nextInt();
		Input2 = scan.nextInt();
		
		if (Input1 > Input2)
		{
			System.out.println(Input1 + " - 82 = " + (Input1-82));
		}
		else
		{
			System.out.println(Input2 + " + 82 = " + (Input2+82));
		}
		
	}
}
