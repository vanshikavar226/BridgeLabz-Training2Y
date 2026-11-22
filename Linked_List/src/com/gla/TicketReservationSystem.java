package com.gla;

public class TicketReservationSystem {
        static class Node {
            int id, seat;
            String customer, movie, time;

            Node next;

            Node(int i, String c, String m, int s, String t) {
                id = i;
                customer = c;
                movie = m;
                seat = s;
                time = t;
            }
        }

        Node head = null;

        // Insert ticket at end
        void insert(int id, String customer, String movie,
                    int seat, String time) {

            Node n = new Node(id, customer, movie, seat, time);

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

        // Delete ticket
        void delete(int id) {
            if (head == null) return;

            Node temp = head, prev = null;

            do {
                if (temp.id == id) {

                    if (temp == head && temp.next == head) {
                        head = null;
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

                    return;
                }

                prev = temp;
                temp = temp.next;

            } while (temp != head);
        }

        // Display tickets
        void display() {
            if (head == null) {
                System.out.println("No Tickets Booked");
                return;
            }

            Node temp = head;

            do {
                System.out.println("Ticket ID: " + temp.id);
                System.out.println("Customer: " + temp.customer);
                System.out.println("Movie: " + temp.movie);
                System.out.println("Seat: " + temp.seat);
                System.out.println("Time: " + temp.time);

                System.out.println("----------------");

                temp = temp.next;

            } while (temp != head);
        }

        // Search by customer
        void searchCustomer(String customer) {
            if (head == null) return;

            Node temp = head;

            do {
                if (temp.customer.equalsIgnoreCase(customer))
                    System.out.println("Ticket Found: " + temp.id);

                temp = temp.next;

            } while (temp != head);
        }

        // Search by movie
        void searchMovie(String movie) {
            if (head == null) return;

            Node temp = head;

            do {
                if (temp.movie.equalsIgnoreCase(movie))
                    System.out.println("Ticket ID: " + temp.id);

                temp = temp.next;

            } while (temp != head);
        }

        // Count tickets
        void count() {
            if (head == null) {
                System.out.println("Total Tickets: 0");
                return;
            }

            int c = 0;
            Node temp = head;

            do {
                c++;
                temp = temp.next;

            } while (temp != head);

            System.out.println("Total Tickets: " + c);
        }

        public static void main(String[] args) {
            TicketReservationSystem t = new TicketReservationSystem();

            t.insert(1, "Rahul", "Avatar", 10, "10:00 AM");
            t.insert(2, "Aman", "Jawan", 15, "12:00 PM");
            t.insert(3, "Priya", "Avatar", 20, "2:00 PM");

            System.out.println("All Tickets:");
            t.display();

            System.out.println("Search Customer:");
            t.searchCustomer("Rahul");

            System.out.println("Search Movie:");
            t.searchMovie("Avatar");

            t.delete(2);

            System.out.println("After Deletion:");
            t.display();

            t.count();
        }
}
