package com.gla.sortingalgorithm;
import java.util.*;
public class Selectionsort {
        public static void main(String[] args) {
            int[] scores = {80, 45, 90, 60, 70};
            for (int i = 0; i < scores.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < scores.length; j++) {
                    if (scores[j] < scores[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
            System.out.println(Arrays.toString(scores));
        }
}
