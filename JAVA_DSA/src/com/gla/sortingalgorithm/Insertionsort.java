package com.gla.sortingalgorithm;
import java.util.*;
public class Insertionsort {
        public static void main(String[] args) {
            int[] ids = {105, 101, 109, 103, 102};
            for (int i = 1; i < ids.length; i++) {
                int key = ids[i];
                int j = i - 1;
                while (j >= 0 && ids[j] > key) {
                    ids[j + 1] = ids[j];
                    j--;
                }
                ids[j + 1] = key;
            }
            System.out.println(Arrays.toString(ids));
        }
}