package Week4;

import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {
		int Input, packets, boxes;
		String remainder = "no";
		final int PACK = 12, BOX = 30; //Pack should contain 15, what a logistical nightmare.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the amount of biscuits you want: ");
		Input = scan.nextInt();
		
		packets = Input/12;
		boxes = packets/30;
		remainder = "with " + Integer.toString(packets%BOX) + " leftover packet(s) and " + Integer.toString(Input%PACK%BOX) + " leftover biscuits.";
		remainder = remainder.replaceAll("0", "no");
		
		System.out.println("There are " + packets + " packets of biscuits: " + boxes + " box(es) " + remainder);
		
		//if (packets > 30) { } //;
		
	}
}
