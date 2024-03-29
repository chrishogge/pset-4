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
import java.util.ArrayList;

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

        in .close();
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
        System.out.print("\n");
        while (validInput) {
            System.out.print("Lower bound: ");
            lowerBound = in .nextInt();
            System.out.print("Upper bound: ");
            upperBound = in .nextInt();
            if (upperBound > lowerBound) {
                validInput = false;
            }
        }
        for (int i = lowerBound; i <= upperBound; i++) {
            if ((i % 2) == 0) {
                integerSum += i;
            }
        }
        System.out.print("\n" + String.format("%,d.", integerSum) + "\n");
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
        System.out.print("\n");
        while (isPositiveInteger1) {
            System.out.print("Positive integer: ");
            reverseIntegerInput = in .nextInt();
            if (reverseIntegerInput > 0) {
                isPositiveInteger1 = false;
            }
        }

        String reverseIntegerString = Integer.toString(reverseIntegerInput);

        String flippedString[] = new String[reverseIntegerString.length()];
        int j = 0;
        for (int i = (reverseIntegerString.length() - 1); i >= 0; i--) {
            flippedString[j] = Character.toString(reverseIntegerString.charAt(i));
            j++;
        }
        System.out.print("\n");
        for (int k = 0; k < reverseIntegerString.length(); k++) {
            if ((k < (reverseIntegerString.length())) && (k != (reverseIntegerString.length() - 1))) {
                System.out.print(String.format("%s, ", flippedString[k]));
            } else if (k == (reverseIntegerString.length() - 1)) {
                System.out.print(String.format("%s.", flippedString[k]) + "\n");
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
        System.out.print("\n");
        while (isPositiveInteger2) {
            System.out.print("Positive integer: ");
            oddSumIntegerInput = in .nextInt();
            if (oddSumIntegerInput > 0) {
                isPositiveInteger2 = false;
            }
        }
        String oddSumIntegerInputString = (Integer.toString(oddSumIntegerInput));
        int oddSum = 0;
        for (int i = 0; i < oddSumIntegerInputString.length(); i++) {
            if (!(Character.getNumericValue(oddSumIntegerInputString.charAt(i)) % 2 == 0)) {
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
        System.out.print("\n");
        while (continueLoop) {
            System.out.print("Non-negative integer: ");
            int inputAverageInt = in .nextInt();
            if (inputAverageInt >= 0) {
                averageInt = averageInt + inputAverageInt;
                i = i + 1;
            } else if (inputAverageInt < 0) {
                continueLoop = false;
            }
        }

        if (i != 0) {
            double averageDouble = ((double) averageInt) / ((double) i);
            System.out.print("\n" + String.format("%,.2f.\n", averageDouble));
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
        System.out.print("\n");
        while (isNegative) {
            System.out.print("Non-negative integer: ");
            inputPrime = in .nextInt();
            if (inputPrime >= 0) {
                isNegative = false;
            }
        }
        for (int i = 2; i <= (inputPrime / 2); i++) {
            remainder = inputPrime % i;
            if (remainder == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.print("\nPrime.\n");
        } else if (!(isPrime)) {
            System.out.print("\nNot prime.\n");
        }
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
        while (isNegative) {
            System.out.print("Positive integer: ");
            fibLength = in .nextInt();
            if ((fibLength > 0) && (fibLength < 93)) {
                isNegative = false;
            }
        }

        for (int i = 2; i < fibLength + 1; i++) {
            fibArray[i] = (fibArray[(i - 2)] + fibArray[(i - 1)]);
        }
        System.out.print("\n" + fibArray[fibLength] + ".\n");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
        boolean isNegative = true;
        double inputFactor = 0;
        System.out.print("\n");
        while (isNegative) {
            System.out.print("Positive integer: ");
            inputFactor = in .nextDouble();
            if (inputFactor > 0) {
                isNegative = false;
            }
        }

        ArrayList < Double > factorArray = new ArrayList < Double > ();
        int j = 0;
        boolean noDuplicates = true;

        for (double i = 1; i <= inputFactor; i++) {
            if ((inputFactor % i) == 0) {
                if (factorArray.size() > 1) {
                    for (int x = 0; x < factorArray.size(); x++) {
                        if (i == factorArray.get(x)) {
                            noDuplicates = false;
                        }
                    }
                }
                if (noDuplicates) {
                    factorArray.add(i);
                    factorArray.add((inputFactor / i));
                }
            } else if (i == 1) {
                factorArray.add(i);
                factorArray.add((inputFactor / i));
                j++;
            }
        }


        String factors = "\n";

        for (int z = 0; z < factorArray.size(); z++) {
            if (z != factorArray.size() - 1) {
                factors += String.format("%.0f, ", factorArray.get(z));
            } else if (z == factorArray.size() - 1) {
                factors += String.format("%.0f.\n", factorArray.get(z));
            }
        }

        System.out.print(factors);
    }


    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
        System.out.print("\n");
        String workingString = "";
        int currentRow = 1;
        int numberSpaces;
        int inputHeight = 0;
        boolean isHeightLimit = true;
        while (isHeightLimit) {
            System.out.print("Height: ");
            inputHeight = in .nextInt();
            if ((inputHeight < 25) && (inputHeight > 0)) {
                isHeightLimit = false;
            }
        }

        for (int i = 0; i < inputHeight; i++) {
            workingString = "";
            currentRow = i + 1;
            numberSpaces = inputHeight - (currentRow);
            for (int k = 0; k < numberSpaces; k++) {
                workingString += " ";
            }
            workingString += "#";
            for (int j = currentRow; j > 0; j--) {
                workingString += "#";
            }
            System.out.print("\n" + workingString);
        }
        System.out.print("\n");
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {
        System.out.print("\n");
        String workingString = "";
        int currentRow = 1;
        int numberSpaces;
        int inputHeight = 0;
        boolean isHeightLimit = true;
        while (isHeightLimit) {
            System.out.print("Height: ");
            inputHeight = in .nextInt();
            if ((inputHeight < 25) && (inputHeight > 0)) {
                isHeightLimit = false;
            }
        }

        for (int i = 0; i < inputHeight; i++) {
            workingString = "";
            currentRow = i + 1;
            numberSpaces = inputHeight - (currentRow);
            for (int k = 0; k < numberSpaces; k++) {
                workingString += " ";
            }
            workingString += "#";
            for (int j = currentRow; j > 0; j--) {
                workingString += "#";
            }
            for (int b = 0; b < 2; b++) {
                workingString += " ";
            }
            workingString += "#";
            for (int j = currentRow; j > 0; j--) {
                workingString += "#";
            }
            System.out.print("\n" + workingString);
        }
        System.out.print("\n");
    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {

        System.out.print("\nNumber: ");
        long inputCard = in .nextLong();
        int cardLength = String.valueOf(inputCard).length();
        int cardArray[] = new int[cardLength];
        int oddCardArray[] = new int[(cardLength / 2)];
        int evenCardArray[] = new int[(cardLength / 2) + 1];
        String firstTwoDigits = (Long.toString(inputCard)).substring(0, 2);
        String firstDigit = (Long.toString(inputCard)).substring(0, 1);

        for (int i = 0; i < cardLength; i++) {
            cardArray[i] = Integer.valueOf((Long.toString(inputCard)).substring(i, i + 1));
        }
        int k = 0;

        if ((cardLength % 2) != 0) {
            for (int j = 1; j < cardLength; j += 2) {
                oddCardArray[k] = cardArray[j];
                k++;
            }
        } else if ((cardLength % 2) == 0) {
            for (int j = cardLength - 2; j > -1; j -= 2) {
                oddCardArray[k] = cardArray[j];
                k++;
            }
        }

        k = 0;

        if ((cardLength % 2) != 0) {
            for (int j = 0; j < cardLength; j += 2) {
                evenCardArray[k] = cardArray[j];
                k++;
            }
        } else if ((cardLength % 2) == 0) {
            for (int j = 1; j < cardLength; j += 2) {
                evenCardArray[k] = cardArray[j];
                k++;
            }
        }

        int oddMultiSum = 0;
        int workingNumber = 0;

        for (int l = 0; l < (cardLength / 2); l++) {
            workingNumber = (2 * oddCardArray[l]) % 10;
            oddMultiSum += workingNumber;
            workingNumber = ((2 * oddCardArray[l]) / 10) % 10;
            oddMultiSum += workingNumber;
        }

        int oddEvenSum = oddMultiSum;
        for (int m = 0; m < (cardLength / 2) + 1; m++) {
            oddEvenSum += evenCardArray[m];
        }

        String lastDigit = (Integer.toString(oddEvenSum)).substring(1, 2);

        if ((lastDigit.equals("0") && (firstTwoDigits.equals("34") || firstTwoDigits.equals("37"))) && cardLength == 15) {
            System.out.println("\nAmex.\n");
        } else if (((lastDigit.equals("0")) && (firstTwoDigits.equals("51") || firstTwoDigits.equals("52") || firstTwoDigits.equals("53") || firstTwoDigits.equals("54") || firstTwoDigits.equals("55"))) && cardLength == 16) {
            System.out.print("\nMastercard.\n");
        } else if (((lastDigit.equals("0")) && (firstDigit.equals("4")) && (cardLength == 13 || cardLength == 16))) {
            System.out.print("\nVisa.\n");
        } else {
            System.out.print("\nInvalid.\n");
        }


    }
}
