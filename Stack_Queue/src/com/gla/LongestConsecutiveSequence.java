package com.gla;
import java.util.*;
public class LongestConsecutiveSequence {
        public static void main(String[] args) {

            int arr[] = {100, 4, 200, 1, 3, 2};

            HashSet<Integer> set = new HashSet<>();

            for (int x : arr) {
                set.add(x);
            }

            int longest = 0;

            for (int x : set) {

                if (!set.contains(x - 1)) {

                    int count = 1;

                    while (set.contains(x + count)) {
                        count++;
                    }

                    longest = Math.max(longest, count);
                }
            }

            System.out.println("Longest Sequence: " + longest);
        }
}
