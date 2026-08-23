package com.gla.array.level2;

import java.util.Scanner;

class FriendsInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Names of friends
        String[] names = {"Amar", "Akbar", "Anthony"};

        // a. Arrays to store age and height
        int[] age = new int[3];
        double[] height = new double[3];

        // Take user input
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i]);

            System.out.print("Age: ");
            age[i] = sc.nextInt();

            System.out.print("Height: ");
            height[i] = sc.nextDouble();
        }

        // b. Find youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // c. Display result
        System.out.println("\nYoungest Friend: " + names[youngestIndex]);
        System.out.println("Tallest Friend: " + names[tallestIndex]);

        sc.close();
    }
}

