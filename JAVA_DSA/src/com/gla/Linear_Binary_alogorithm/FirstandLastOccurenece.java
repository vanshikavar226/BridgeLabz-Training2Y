package com.gla.Linear_Binary_alogorithm;
public class FirstandLastOccurenece {
        public static int firstOccurrence(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;

            int answer = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    answer = mid;
                    right = mid - 1;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return answer;
        }
        public static int lastOccurrence(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
            int answer = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    answer = mid;
                    left = mid + 1;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return answer;
        }
        public static void main(String[] args) {
            int[] arr = {1, 2, 2, 2, 3, 4, 5};
            int target = 2;
            System.out.println(
                    "First: " + firstOccurrence(arr, target)
            );
            System.out.println(
                    "Last: " + lastOccurrence(arr, target)
            );
        }
}
