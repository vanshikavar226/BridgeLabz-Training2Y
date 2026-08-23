package com.gla.array.level1;

import java.util.Scanner;

class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Define an integer array of 5 elements
        int[] num = new int[5];

        // Take user input
        for (int i = 0; i < num.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            num[i] = sc.nextInt();
        }

        System.out.println("\nNumber Analysis:");

        // b & c. Loop through the array and check conditions
        for (int i = 0; i < num.length; i++) {

            if (num[i] > 0) {
                if (num[i] % 2 == 0) {
                    System.out.println(num[i] + " is Positive and Even");
                } else {
                    System.out.println(num[i] + " is Positive and Odd");
                }
            }
            else if (num[i] < 0) {
                System.out.println(num[i] + " is Negative");
            }
            else {
                System.out.println(num[i] + " is Zero");
            }
        }

        // d. Compare first and last elements
        System.out.println("\nComparison of First and Last Elements:");

        if (num[0] == num[num.length - 1]) {
            System.out.println("First and last elements are Equal");
        }
        else if (num[0] > num[num.length - 1]) {
            System.out.println("First element is Greater than last element");
        }
        else {
            System.out.println("First element is Less than last element");
        }

        sc.close();
    }
}

