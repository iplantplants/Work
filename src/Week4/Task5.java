package Week4;

import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		double weight, height, BMI;
		String interpretation = "Underweight";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter your weight in Kilograms: ");	weight = scan.nextDouble();
		System.out.print("Enter your height in Metres: "); height = scan.nextDouble();
		
		BMI = weight/Math.sqrt(height);
		

		//if bmi less than 18.5 it defaults to underweight
		if (BMI > 18.5 && BMI < 24.9) interpretation = "Normal";
		if (BMI > 25 && BMI < 29.9) interpretation = "Overweight";
		if (BMI > 30) interpretation = "Obese";
		
		System.out.printf("Your BMI is %.2f which means you are in the " + interpretation + " range", BMI);
	}
}
