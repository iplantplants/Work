package Week3.drills;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int Input, product;
		System.out.println("Enter a 5-digit integer");
		Input = scan.nextInt();
		product = (Input/10000) * (Input%10000/1000) * (Input%1000/100) * (Input%100/10) * (Input%10/1);
		System.out.println("The product of all of the digits is " + product);
	}
}
