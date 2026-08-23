package com.gla.array.level1;
import java.util.Scanner;

class FindFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // b. Initialize maxFactor, factors array, and index
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // c. Loop from 1 to number to find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                // d. Resize array if it becomes full
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];

                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                factors[index] = i;
                index++;
            }
        }

        // e. Display the factors
        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        sc.close();
    }
}

