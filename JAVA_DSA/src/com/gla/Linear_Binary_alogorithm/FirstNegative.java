package com.gla.Linear_Binary_alogorithm;
public class FirstNegative {
        public static int firstNegative(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    return i;
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            int[] arr = {5, 10, 8, -3, -7};
            System.out.println(firstNegative(arr));
        }
}
