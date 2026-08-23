package com.gla.array.level2;

import java.util.Scanner;

class BMIUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take input for number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // b. 2D array: [][0] = weight, [][1] = height, [][2] = BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // c. Take input with validation
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Weight (kg): ");
            personData[i][0] = sc.nextDouble();

            if (personData[i][0] <= 0) {
                System.out.println("Invalid weight. Enter again.");
                i--;
                continue;
            }

            System.out.print("Height (m): ");
            personData[i][1] = sc.nextDouble();

            if (personData[i][1] <= 0) {
                System.out.println("Invalid height. Enter again.");
                i--;
            }
        }

        // d. Calculate BMI and determine weight status
        for (int i = 0; i < number; i++) {
            personData[i][2] =
                    personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // e. Display results
        System.out.println("\nBMI Report:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("Height: " + personData[i][1] + " m");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }

        sc.close();
    }
}
