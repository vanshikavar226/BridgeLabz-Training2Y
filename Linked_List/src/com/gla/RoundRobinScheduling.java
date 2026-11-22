package com.gla;

public class RoundRobinScheduling {
        static class Node {
            int id, burst, priority;
            int remaining;
            Node next;

            Node(int i, int b, int p) {
                id = i;
                burst = b;
                priority = p;
                remaining = b;
            }
        }

        Node head = null;

        // Insert process
        void insert(int id, int burst, int priority) {
            Node n = new Node(id, burst, priority);

            if (head == null) {
                head = n;
                n.next = head;
                return;
            }

            Node t = head;

            while (t.next != head)
                t = t.next;

            t.next = n;
            n.next = head;
        }

        // Display circular list
        void display() {
            if (head == null) return;

            Node t = head;

            do {
                System.out.println("P" + t.id +
                        " Remaining Time: " + t.remaining);

                t = t.next;
            } while (t != head);
        }

        // Round Robin Scheduling
        void schedule(int quantum) {
            if (head == null || quantum <= 0) return;

            int time = 0;
            int totalWT = 0;
            int totalTAT = 0;
            int completed = 0;

            Node t = head;

            while (head != null) {

                if (t.remaining > 0) {

                    int execute = Math.min(quantum, t.remaining);

                    t.remaining -= execute;
                    time += execute;

                    System.out.println("Process P" + t.id +
                            " executes for " + execute);

                    if (t.remaining == 0) {

                        int tat = time;
                        int wt = tat - t.burst;

                        totalTAT += tat;
                        totalWT += wt;
                        completed++;

                        System.out.println("P" + t.id + " Completed");

                        // Delete completed process
                        if (t == head && t.next == head) {
                            head = null;
                            break;
                        }

                        if (t == head) {
                            Node last = head;

                            while (last.next != head)
                                last = last.next;

                            head = head.next;
                            last.next = head;
                            t = head;
                        } else {
                            Node prev = head;

                            while (prev.next != t)
                                prev = prev.next;

                            prev.next = t.next;
                            t = t.next;
                        }
                    } else {
                        t = t.next;
                    }

                    System.out.println("Remaining Processes:");
                    display();
                } else {
                    t = t.next;
                }
            }

            if (completed > 0) {
                System.out.println("Average Waiting Time: " +
                        (double) totalWT / completed);

                System.out.println("Average Turnaround Time: " +
                        (double) totalTAT / completed);
            }
        }

        public static void main(String[] args) {
            RoundRobinScheduling r = new RoundRobinScheduling();

            r.insert(1, 5, 1);
            r.insert(2, 4, 2);
            r.insert(3, 6, 1);

            System.out.println("Process List:");
            r.display();

            System.out.println("Scheduling:");
            r.schedule(2);
        }
}
