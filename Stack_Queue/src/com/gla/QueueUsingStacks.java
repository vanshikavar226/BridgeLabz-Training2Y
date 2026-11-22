package com.gla;
import java.util.Stack;
public class QueueUsingStacks {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Enqueue
        void enqueue(int x) {
            s1.push(x);
        }

        // Dequeue
        int dequeue() {
            if (s1.empty() && s2.empty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }

        // Display
        void display() {
            System.out.println("Queue: " + s2);
            System.out.println("Remaining Stack: " + s1);
        }

        public static void main(String[] args) {

            QueueUsingStacks q = new QueueUsingStacks();

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);

            System.out.println(q.dequeue());
            System.out.println(q.dequeue());

            q.enqueue(40);

            System.out.println(q.dequeue());
        }
}
