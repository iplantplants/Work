package Week4.drills;

import java.util.Scanner;
public class drill1 {
	public static void main(String[] args) {
	int Input;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter a 4-digit integer");
	Input = scan.nextInt();
	
	System.out.println("The product of all of the digits is " + (Input/1000)*(Input%1000/100)*(Input%1000%100/10)*(Input%1000%100%10/1));
		
		
	}
	
}
