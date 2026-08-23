package com.gla.array.level2;

import java.util.Scanner;

class LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // b. Define array with maxDigit = 10
        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        // c. Index variable
        int index = 0;

        // d & e & f. Extract digits and store in array
        while (number != 0) {
            digits[index] = number % 10; // last digit
            number = number / 10;         // remove last digit
            index++;

            if (index == maxDigit) {
                break; // stop if array is full
            }
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
