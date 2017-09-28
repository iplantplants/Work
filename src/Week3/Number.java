package Week3;


//*******************************************************************
//   Echo.java   (Java Application)
//   Classes:  Echo
//*******************************************************************

import java.util.Scanner ;

public class Number {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      String message1, message2;
      int number;
      System.out.println ("Enter a line:");
      message1 = scan.nextLine();
      System.out.println("Enter another line:");
      message2 = scan.nextLine();
      //System.out.println (message2 + ", " + message1);
      
      number = Integer.parseInt(message1 + message2);
      
      System.out.println(number + 1);
   }  // method main
}  // class Echo
