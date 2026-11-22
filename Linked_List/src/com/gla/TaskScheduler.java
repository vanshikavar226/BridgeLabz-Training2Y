package com.gla;

public class TaskScheduler {
        static class Node {
            int id, priority;
            String name, date;
            Node next;

            Node(int i, String n, int p, String d) {
                id = i;
                name = n;
                priority = p;
                date = d;
            }
        }

        Node head = null;
        Node current = null;

        // Insert at beginning
        void insertFirst(int id, String name, int p, String date) {
            Node n = new Node(id, name, p, date);

            if (head == null) {
                head = n;
                n.next = head;
            } else {
                Node temp = head;

                while (temp.next != head)
                    temp = temp.next;

                n.next = head;
                temp.next = n;
                head = n;
            }
        }

        // Insert at end
        void insertEnd(int id, String name, int p, String date) {
            Node n = new Node(id, name, p, date);

            if (head == null) {
                head = n;
                n.next = head;
                return;
            }

            Node temp = head;

            while (temp.next != head)
                temp = temp.next;

            temp.next = n;
            n.next = head;
        }

        // Insert at position
        void insertAt(int pos, int id, String name, int p, String date) {
            if (pos <= 1) {
                insertFirst(id, name, p, date);
                return;
            }

            Node temp = head;

            for (int i = 1; i < pos - 1 && temp.next != head; i++)
                temp = temp.next;

            Node n = new Node(id, name, p, date);
            n.next = temp.next;
            temp.next = n;
        }

        // Delete task
        void delete(int id) {
            if (head == null) return;

            Node temp = head, prev = null;

            do {
                if (temp.id == id) {
                    if (temp == head && temp.next == head) {
                        head = null;
                        current = null;
                        return;
                    }

                    if (prev == null) {
                        Node last = head;

                        while (last.next != head)
                            last = last.next;

                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }

                    if (current == temp)
                        current = temp.next;

                    return;
                }

                prev = temp;
                temp = temp.next;

            } while (temp != head);
        }

        // View current task and move next
        void nextTask() {
            if (head == null) return;

            if (current == null)
                current = head;

            System.out.println("Current Task: " + current.name);
            current = current.next;
        }

        // Display
        void display() {
            if (head == null) return;

            Node temp = head;

            do {
                System.out.println(temp.id + " " +
                        temp.name + " " + temp.priority +
                        " " + temp.date);

                temp = temp.next;
            } while (temp != head);
        }

        // Search by priority
        void search(int p) {
            if (head == null) return;

            Node temp = head;

            do {
                if (temp.priority == p)
                    System.out.println(temp.name);

                temp = temp.next;
            } while (temp != head);
        }

        public static void main(String[] args) {
            TaskScheduler t = new TaskScheduler();

            t.insertFirst(1, "Assignment", 2, "25-11-2026");
            t.insertEnd(2, "Project", 1, "28-11-2026");
            t.insertAt(2, 3, "Study", 3, "30-11-2026");

            t.display();

            t.nextTask();
            t.nextTask();

            t.search(2);
            t.delete(1);
        }
}
