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
import java.util.Arrays;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

        // ps.sum();
        // ps.reverse();
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
			boolean validInput = true;
			int lowerBound = 0;
			int upperBound = 0;
			int integerSum = 0;
			while(validInput){
				System.out.print("\nLower bound: ");
				lowerBound = in.nextInt();
				System.out.print("Upper bound: ");
				upperBound = in.nextInt();
				if(upperBound > lowerBound){
					validInput = false;
				}
			}
			for(int i=lowerBound; i<=upperBound; i++){
				if((i % 2) == 0){
					integerSum += i;
				}
			}
			System.out.print("\n" + String.format("%,d.",integerSum) + "\n");
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
			boolean isPositiveInteger1 = true;
			int reverseIntegerInput = 0;
			while(isPositiveInteger1){
				System.out.print("\nPositive integer: ");
				reverseIntegerInput = in.nextInt();
				if(reverseIntegerInput > 0){
					isPositiveInteger1 = false;
				}
			}

			String reverseIntegerString = Integer.toString(reverseIntegerInput);

			String flippedString[] = new String[reverseIntegerString.length()];
			int j = 0;
			for(int i = (reverseIntegerString.length()-1); i >= 0; i--){
				flippedString[j] = Character.toString(reverseIntegerString.charAt(i));
				j++;
			}
			System.out.print("\n");
			for(int k = 0; k < reverseIntegerString.length(); k++){
				if((k < (reverseIntegerString.length())) && (k != (reverseIntegerString.length()-1)) ){
				System.out.print(String.format("%s, ",flippedString[k]));
			} else if(k == (reverseIntegerString.length()-1)){
				System.out.print(String.format("%s.",flippedString[k]) + "\n");
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
			boolean isPositiveInteger2 = true;
			int oddSumIntegerInput = 0;
			while(isPositiveInteger2){
				System.out.print("\nPositive integer: ");
				oddSumIntegerInput = in.nextInt();
				if(oddSumIntegerInput > 0){
					isPositiveInteger2 = false;
				}
			}
			String oddSumIntegerInputString = (Integer.toString(oddSumIntegerInput));
			int oddSum = 0;
			for(int i = 0; i < oddSumIntegerInputString.length(); i++){
				if(!(Character.getNumericValue(oddSumIntegerInputString.charAt(i))%2 == 0)){
					oddSum += Character.getNumericValue(oddSumIntegerInputString.charAt(i));
				}
			}

			System.out.println("\n" + oddSum + ".\n");

    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
	boolean continueLoop = true;
    	int averageInt = 0;
    	int sumInt = 0;
    	int i = 0;
    
	while(continueLoop){
          System.out.print("Non-negative integer: ");
          int inputAverageInt = in.nextInt();
          if(inputAverageInt >= 0){
              averageInt = averageInt + inputAverageInt;
      	      i = i +1;
       	} else if(inputAverageInt < 0){
		continueLoop = false;
      		}
    	}
    
  	if(i!=0){
    	double averageDouble = ((double)averageInt) / ((double)i);
    	System.out.print("\n" + String.format("%,.2f.\n",averageDouble));
  	}
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
    int remainder = -1;
    boolean isPrime = true;
    boolean isNegative = true;
    int inputPrime = -1;
    while(isNegative){
       System.out.print("\nNon-negative integer: ");
       inputPrime = in.nextInt();
       if(inputPrime >= 0){
         isNegative = false;
    }
    }
    for(int i=2; i<= (inputPrime/2); i++){
      remainder = inputPrime%i;
      if(remainder==0){
        isPrime = false;
        break;
      }
    }

    System.out.print("\n" + isPrime);
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {
    System.out.print("\n");
    long fibArray[] = new long[93];
    fibArray[0] = 0;
    fibArray[1] = 1;
    boolean isNegative = true;
    int fibLength = 0;
    while(isNegative){
       System.out.print("Positive integer: ");
       fibLength = in.nextInt();
       if((fibLength > 0) && (fibLength < 93)){
         isNegative = false;
      }
    }
  
    for(int i = 2; i < fibLength+1; i++){
      fibArray[i] = (fibArray[(i-2)] + fibArray[(i-1)]);
    }
    System.out.print("\n" + fibArray[fibLength] + ".\n");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {

    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {

    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {

    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {

    }
}
