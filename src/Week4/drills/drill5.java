package Week4.drills;


import java.util.Scanner;

public class drill5 {
	public static void main(String[] args) {
		int Input;
		boolean evaluate;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a 3-digit integer");
		Input = scan.nextInt();
		
		if ((Input/100)+(Input%100/10)+(Input%100%10) > (Input/100)*(Input%100/10))
		{
			evaluate = true;
		}
		else
		{
			evaluate = false;
		}
		System.out.println("The number is " + evaluate);
	}
}
