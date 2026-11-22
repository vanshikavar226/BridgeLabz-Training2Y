package com.gla;
import java.util.Stack;
public class SortStackRecursion {
        static void sortedInsert(Stack<Integer> s, int x) {

            if (s.empty() || s.peek() <= x) {
                s.push(x);
                return;
            }

            int temp = s.pop();

            sortedInsert(s, x);

            s.push(temp);
        }

        static void sort(Stack<Integer> s) {

            if (s.empty())
                return;

            int x = s.pop();

            sort(s);

            sortedInsert(s, x);
        }

        public static void main(String[] args) {

            Stack<Integer> s = new Stack<>();

            s.push(30);
            s.push(10);
            s.push(40);
            s.push(20);

            sort(s);

            System.out.println("Sorted Stack: " + s);
        }
}
