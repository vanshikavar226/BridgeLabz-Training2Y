package com.gla;
import java.util.*;
public class PairWithGivenSum {
        public static void main(String[] args) {

            int arr[] = {2, 7, 11, 15};

            int target = 9;

            HashSet<Integer> set = new HashSet<>();

            boolean found = false;

            for (int i = 0; i < arr.length; i++) {

                int x = target - arr[i];

                if (set.contains(x)) {

                    System.out.println("Pair Found: " + x + " " + arr[i]);

                    found = true;
                    break;
                }

                set.add(arr[i]);
            }

            if (!found) {
                System.out.println("Pair Not Found");
            }
        }
}
