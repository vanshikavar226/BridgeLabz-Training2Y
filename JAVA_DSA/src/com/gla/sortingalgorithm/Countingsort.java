package com.gla.sortingalgorithm;
import java.util.*;
public class Countingsort {
        public static void main(String[] args) {
            int[] ages = {15, 12, 18, 10, 15, 13, 12};
            int[] count = new int[19];
            for (int age : ages) {
                count[age]++;
            }
            int index = 0;
            for (int age = 10; age <= 18; age++) {
                while (count[age] > 0) {
                    ages[index] = age;
                    index++;

                    count[age]--;
                }
            }
            System.out.println(Arrays.toString(ages));
        }
}