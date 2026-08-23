package com.gla.array.level2;

import java.util.Scanner;

class BMICalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take input for number of persons
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        // b. Create arrays
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // c. Take input for weight and height
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Weight (kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Height (m): ");
            height[i] = sc.nextDouble();
        }

        // d. Calculate BMI and determine status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            // f. Determine weight status using BMI table
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // e. Display results
        System.out.println("\nBMI Details:");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + height[i] + " m");
            System.out.println("Weight: " + weight[i] + " kg");
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Status: " + status[i]);
            System.out.println();
        }

        sc.close();
    }
}

