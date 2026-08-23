package com.gla.array.level1;

import java.util.Scanner;

class OddEvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Get integer input and check for natural number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a natural number.");
            return;   // exit program
        }

        // b. Create odd and even arrays
        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];

        // c. Index variables
        int evenIndex = 0;
        int oddIndex = 0;

        // d. Loop from 1 to number and store odd/even
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // e. Print odd numbers array
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        // Print even numbers array
        System.out.println("\n\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        sc.close();
    }
}

