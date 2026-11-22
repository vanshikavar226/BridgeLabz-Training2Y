package com.gla;
import java.util.Stack;
public class StockSpan {
        public static void main(String[] args) {

            int arr[] = {100, 80, 60, 70, 60, 75, 85};

            int n = arr.length;

            int span[] = new int[n];

            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < n; i++) {

                while (!s.empty() && arr[s.peek()] <= arr[i]) {
                    s.pop();
                }

                if (s.empty()) {
                    span[i] = i + 1;
                } else {
                    span[i] = i - s.peek();
                }

                s.push(i);
            }

            System.out.println("Stock Span:");

            for (int i = 0; i < n; i++) {
                System.out.print(span[i] + " ");
            }
        }
}
