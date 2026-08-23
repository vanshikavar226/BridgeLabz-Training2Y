package com.gla.array.level2;

import java.util.Scanner;

class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // b. Initial maxDigit = 10
        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        // c. Index variable
        int index = 0;

        // d, e, f. Extract digits and dynamically increase array size
        while (number != 0) {

            // a. If index equals maxDigit, increase size by 10
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;

                // b. Create temp array and copy elements
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign temp to digits
                digits = temp;
            }

            // Store digit
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        // g. Variables for largest and second largest
        int largest = 0;
        int secondLargest = 0;

        // h. Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // i. Display result
        System.out.println("\nLargest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);

        sc.close();
    }
}

