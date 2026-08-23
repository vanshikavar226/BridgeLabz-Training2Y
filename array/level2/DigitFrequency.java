package com.gla.array.level2;

import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take input for a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // b. Find count of digits
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // c. Store digits in array
        int[] digits = new int[count];
        temp = number;
        int index = 0;

        while (temp != 0) {
            digits[index] = temp % 10;
            temp /= 10;
            index++;
        }

        // d. Frequency array of size 10
        int[] frequency = new int[10];

        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // e. Display frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}

