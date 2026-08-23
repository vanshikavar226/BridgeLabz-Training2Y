package com.gla.array.level1;

import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Get integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Define integer array to store results from 1 to 10
        int[] table = new int[10];

        // b. Loop from 1 to 10 and store results
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // c. Display the result in required format
        System.out.println("\nMultiplication Table:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }

        sc.close();
    }
}


