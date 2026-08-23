package com.gla.array.level2;

import java.util.Scanner;

class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // b. Find count of digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // c. Store digits in array
        int[] digits = new int[count];
        temp = number;

        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        // d. Create reverse array
        int[] reverse = new int[count];
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }

        // e. Display reversed number
        System.out.print("Reversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }

        sc.close();
    }
}
