package com.gla.array.level1;

import java.util.Scanner;

class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take integer input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Array to store multiplication results from 6 to 9
        int[] multiplicationResult = new int[4];

        // b. Find multiplication table from 6 to 9
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }

        // c. Display the result
        System.out.println("\nMultiplication Table from 6 to 9:");
        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }

        sc.close();
    }
}

