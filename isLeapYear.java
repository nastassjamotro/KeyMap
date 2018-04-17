import java.util.Scanner;

public class isLeapYear {
  public static void main(String[] args) {
    boolean cont = true;
    System.out.println("This program will check to see if the year you are thinking of is a leap year.");
    while (cont = true) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter in a year after 1582: ");
      final int year = scan.nextInt();
      
      if (year <= 1582) {
        System.out.println("Let's learn how to read shall we? It said enter a year AFTER 1582!");
        System.out.println("Now would you like to try this again? Y/N: ");
        String reply = scan.next();
        if (reply.charAt(0) == 'Y' || reply.charAt(0) == 'y') {
          cont = true;
        } else {
          System.exit(0);
        }
      } else if ((year % 4 == 0 && year % 100 > 0) || (year % 400 == 0)) {
        System.out.println(year + " is a leap year! Good on ya. Your guessing skills are pretty good.");
        System.out.println("Would you like to test your guessing skills again? Y/N: ");
        String reply2 = scan.next();
        if (reply2.charAt(0) == 'Y' || reply2.charAt(0) == 'y') {
          cont = true;
        } else {
          System.exit(0);
        }
      } else {
        System.out.println(year + " is NOT a leap year!");
        System.out.println("So sad. Try again? Y/N: ");
        String reply3 = scan.next();
        if (reply3.charAt(0) == 'Y' || reply3.charAt(0) == 'y') {
          cont = true;
        } else {
          System.exit(0);
        }
      }
    }
  }
}