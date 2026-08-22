package com.gla.sortingalgorithm;
import java.util.*;
public class Bubblesort {
        public static void main(String[] args) {
            int[] marks = {75, 45, 90, 60, 82};
            for (int i = 0; i < marks.length - 1; i++) {
                for (int j = 0; j < marks.length - 1 - i; j++) {
                    if (marks[j] > marks[j + 1]) {
                        int temp = marks[j];
                        marks[j] = marks[j + 1];
                        marks[j + 1] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(marks));
        }
}