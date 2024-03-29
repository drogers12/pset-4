/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();

        in.close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {
       int sum = 0;
       int lowerBound;
       int upperBound;

       System.out.println("");

       do
       {
           System.out.print("Lower bound: ");
           lowerBound = in.nextInt();
           System.out.print("Upper bound: ");
           upperBound = in.nextInt();
       } while (lowerBound > upperBound);

       if ((lowerBound % 2) != 0) {
           lowerBound = lowerBound+1;
       }
       for (int i = lowerBound; i <= upperBound; i = i + 2) {
           sum += i;
       }
       System.out.printf("\n%d.\n\n", sum);
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {

      int userInteger = 0;
      do
      {
          System.out.print("Positive integer: ");
          userInteger = in.nextInt();
      } while (userInteger < 1);

      System.out.printf("\n");

      int divisionFactor = 1;
      int singleDigit = 0;

      while (divisionFactor<=userInteger){
        singleDigit = (userInteger/divisionFactor)%10;
        System.out.print(singleDigit);
        divisionFactor *= 10;
        if (divisionFactor <= userInteger){
          System.out.print(", ");
        }else{
          System.out.print(".\n");
        }
      }
    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
      int numberSum = 0;
      int userInteger = 0;
      int divisionFactor = 1;
      int singleDigit = 0;

      System.out.printf("\n");

      do
      {
          System.out.print("Positive integer: ");
          userInteger = in.nextInt();
      } while (userInteger < 1);

      while (divisionFactor<=userInteger){
        singleDigit = (userInteger/divisionFactor)%10;
        if (singleDigit%2 == 1){
          numberSum = numberSum + singleDigit;
        }
        divisionFactor *= 10;
        if (divisionFactor>userInteger){
          System.out.println("\n" + numberSum + ".");
        }
      }
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      double userInteger = 0;
      double total = 0;
      double count = 0;

      System.out.printf("\n");

      do
      {
          System.out.print("Non-negative integer: ");
          userInteger = in.nextDouble();
          if (userInteger >= 0){
            total += userInteger;
            count++;
          }
      } while (userInteger >= 0);
      double average = total/count;
      System.out.printf("\n%,.2f.\n\n", average);
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
        boolean isPrime = true;
        int integer;
        do
        {
           System.out.print("Non-negative integer: ");
           integer = in.nextInt();
        } while (integer < 0);

        if (integer == 1) {
           isPrime = true;
        } else if (integer == 0) {
           isPrime = false;
        }

        for (int i = 2; i < integer; i++) {
           if (integer % i == 0 && integer != i) {
               isPrime = false;
           }
        }

        if (isPrime) {
           System.out.println("\nPrime.\n");
        } else {
           System.out.println("\nNot prime.\n");
        }
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {

      int integer;
      int previousInt = 0;
      int currentInt = 1;
      int nextInt = 1;

      do
      {
          System.out.print("Positive integer: ");
          integer = in.nextInt();
      } while (integer < 1 || integer > 92);

      for (int i = 1; i < integer; i++) {
          nextInt = previousInt + currentInt;
          previousInt = currentInt;
          currentInt = nextInt;
      }
      System.out.printf("\n%d.\n\n", nextInt);
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {

      int integer;
      int previousInt;

      do
      {
          System.out.print("Positive integer: ");
          integer = in.nextInt();

      } while (integer < 1);

      System.out.printf("\n1, %d", integer);

      for (int i = 2; i <= integer/i; i++) {

          if (integer % i == 0) {
              System.out.printf(", %d, %d", i, integer/i);
          }

      }

      System.out.print(".\n\n");

    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {


      int spaces;
      int dashes;
      int height;

      do
      {
          System.out.print("Height: ");
          height = in.nextInt();
      } while (height < 1 || height > 24);

      System.out.println("");

      for (int i = 1; i <= height; i++){
        for (spaces = (height - i); spaces >= 0; spaces--){
            System.out.printf(" ");
        }
        for (dashes = 1; dashes <= (i + 1); dashes++){
            System.out.printf("#");
        }
        System.out.println("");
      }
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {

      int spaces;
      int dashes;
      int height;

      System.out.printf("\n");

      do
      {
          System.out.print("Height: ");
          height = in.nextInt();
      } while (height < 1 || height > 24);

      System.out.printf("\n");

      for (int i = 1; i <= height; i++){
        for (spaces = (height - i); spaces >= 0; spaces--){
            System.out.printf(" ");
        }
        for (dashes = 1; dashes <= (i + 1); dashes++){
            System.out.printf("#");
        }

        System.out.print("  ");

        for (int k = 1; k < dashes; k++){
          System.out.print("#");
        }
        System.out.println("");
      }
      System.out.println("");
    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {

      long number;
      long temp = 0;
      long oddSum = 0;
      long totalSum = 0;
      String totalSumString;



        do
        {
            System.out.print("Number: ");
            number = in.nextLong();
        } while (number <= 0);

        String numberString = Long.toString(number);

        for (int i = numberString.length()-2; i >= 0; i -= 2) {
            temp = Integer.parseInt(numberString.substring(i,i+1))*2;
            for (int j = 0; j < String.valueOf(temp).length(); j++) {
                oddSum += Integer.parseInt(String.valueOf(temp).substring(j, j+1));
            }
        }

        for (int i = numberString.length()-1; i >= 0; i -= 2) {
            totalSum += Integer.parseInt(numberString.substring(i,i+1));
        }

        totalSum += oddSum;
        totalSumString = String.valueOf(totalSum);

        if (totalSum % 10 == 0) {
            if (numberString.length() == 15 && (numberString.substring(0,2).equals("34") || numberString.substring(0,2).equals("37"))) {
                System.out.println("\nAmex.\n");
            } else if (numberString.length() == 16 && (numberString.substring(0,2).equals("51")
              || numberString.substring(0,2).equals("52") || numberString.substring(0,2).equals("53")
              || numberString.substring(0,2).equals("54") || numberString.substring(0,2).equals("55"))) {
                System.out.println("\nMastercard.\n");
            } else if ((numberString.length() == 16 || numberString.length() == 13) && numberString.substring(0,1).equals("4")) {
                System.out.println("\nVisa.\n");
            } else {
                System.out.println("\nInvalid.\n");
            }
        } else {
            System.out.println("\nInvalid.\n");
        }
    }
}
