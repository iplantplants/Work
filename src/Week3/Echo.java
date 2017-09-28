package Week3;

//*******************************************************************
//   Echo.java   (Java Application)
//   Classes:  Echo
//*******************************************************************

import java.util.Scanner ;

public class Echo {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      String message;
      System.out.println ("Enter a line of text:");
      message = scan.nextLine();
      System.out.println ("You entered: \"" + message + "\"");
   }  // method main
}  // class Echo
