package com.gla;

public class StudentRecordManagement {
        static class Node {
            int roll, age;
            String name, grade;
            Node next;

            Node(int r, String n, int a, String g) {
                roll = r;
                name = n;
                age = a;
                grade = g;
                next = null;
            }
        }

        Node head = null;

        // Insert at beginning
        void insertFirst(int r, String n, int a, String g) {
            Node newNode = new Node(r, n, a, g);
            newNode.next = head;
            head = newNode;
        }

        // Insert at end
        void insertEnd(int r, String n, int a, String g) {
            Node newNode = new Node(r, n, a, g);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }

        // Insert at position (1-based)
        void insertAt(int pos, int r, String n, int a, String g) {
            if (pos == 1) {
                insertFirst(r, n, a, g);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }

            Node newNode = new Node(r, n, a, g);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Delete by roll number
        void delete(int roll) {
            if (head == null) return;

            if (head.roll == roll) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.roll != roll)
                temp = temp.next;

            if (temp.next != null)
                temp.next = temp.next.next;
        }

        // Search student
        void search(int roll) {
            Node temp = head;

            while (temp != null) {
                if (temp.roll == roll) {
                    System.out.println("Student Found: " + temp.name);
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Student Not Found");
        }

        // Update grade
        void update(int roll, String grade) {
            Node temp = head;

            while (temp != null) {
                if (temp.roll == roll) {
                    temp.grade = grade;
                    return;
                }
                temp = temp.next;
            }
        }

        // Display
        void display() {
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.roll + " " + temp.name +
                        " " + temp.age + " " + temp.grade);
                temp = temp.next;
            }
        }

        public static void main(String[] args) {
            StudentRecordManagement s = new StudentRecordManagement();

            s.insertFirst(1, "Rahul", 20, "A");
            s.insertEnd(2, "Aman", 21, "B");
            s.insertAt(2, 3, "Priya", 19, "A");

            s.display();

            s.search(2);
            s.update(2, "A+");
            s.delete(1);

            System.out.println("After Operations:");
            s.display();
        }
}
