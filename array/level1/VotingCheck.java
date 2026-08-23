package com.gla.array.level1;
import java.util.Scanner;

class VotingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Define an array of 10 integer elements
        int[] age = new int[10];

        // Take user input
        for (int i = 0; i < age.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            age[i] = sc.nextInt();
        }

        System.out.println("\nVoting Eligibility Result:");

        // b. Loop through the array and check conditions
        for (int i = 0; i < age.length; i++) {
            if (age[i] < 0) {
                System.out.println("Invalid age");
            } else if (age[i] >= 18) {
                System.out.println("The student with the age " + age[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + age[i] + " cannot vote.");
            }
        }

        sc.close();
    }
}



