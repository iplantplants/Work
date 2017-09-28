package Week4.drills;


import java.util.Scanner;
public class drill3 {
	public static void main(String[] args) {
		int Input1, Input2;
		String result;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter two integers:");
		Input1 = scan.nextInt();
		Input2 = scan.nextInt();
		
		if (Input1 < Input2) result = Input1 + " + 98 = " + (int)(Input1 + 98);
		else result = Input2 + " - 98 = " + (int)(Input2 - 98);
		
		System.out.println(result);
			
		
	}
	
}
