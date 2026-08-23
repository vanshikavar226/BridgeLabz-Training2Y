package com.gla.array.level1;

import java.util.Scanner;

class TwoDToOneD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = sc.nextInt();

        // Create 2D array (matrix)
        int[][] matrix = new int[rows][columns];

        // Take user input for 2D array
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // b. Create 1D array of size rows * columns
        int[] array = new int[rows * columns];

        // c. Copy elements from 2D array to 1D array
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display 1D array
        System.out.println("\n1D Array Elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        sc.close();
    }
}

