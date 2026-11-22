package com.gla;

public class MovieManagementSystem {
        static class Node {
            String title, director;
            int year;
            double rating;

            Node prev, next;

            Node(String t, String d, int y, double r) {
                title = t;
                director = d;
                year = y;
                rating = r;
            }
        }

        Node head = null, tail = null;

        // Insert at beginning
        void insertFirst(String t, String d, int y, double r) {
            Node n = new Node(t, d, y, r);

            if (head == null) {
                head = tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
        }

        // Insert at end
        void insertEnd(String t, String d, int y, double r) {
            Node n = new Node(t, d, y, r);

            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                n.prev = tail;
                tail = n;
            }
        }

        // Insert at position
        void insertAt(int pos, String t, String d, int y, double r) {
            if (pos <= 1) {
                insertFirst(t, d, y, r);
                return;
            }

            Node temp = head;

            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }

            if (temp == tail) {
                insertEnd(t, d, y, r);
                return;
            }

            Node n = new Node(t, d, y, r);
            n.next = temp.next;
            n.prev = temp;
            temp.next.prev = n;
            temp.next = n;
        }

        // Delete by title
        void delete(String title) {
            Node temp = head;

            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {

                    if (temp.prev != null)
                        temp.prev.next = temp.next;
                    else
                        head = temp.next;

                    if (temp.next != null)
                        temp.next.prev = temp.prev;
                    else
                        tail = temp.prev;

                    return;
                }
                temp = temp.next;
            }
        }

        // Search by director
        void search(String director) {
            Node temp = head;

            while (temp != null) {
                if (temp.director.equalsIgnoreCase(director))
                    System.out.println(temp.title);

                temp = temp.next;
            }
        }

        // Search by rating
        void searchRating(double rating) {
            Node temp = head;

            while (temp != null) {
                if (temp.rating == rating)
                    System.out.println(temp.title);

                temp = temp.next;
            }
        }

        // Update rating
        void update(String title, double rating) {
            Node temp = head;

            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    temp.rating = rating;
                    return;
                }
                temp = temp.next;
            }
        }

        // Forward display
        void forward() {
            Node temp = head;

            while (temp != null) {
                System.out.println(temp.title + " " +
                        temp.director + " " + temp.year +
                        " " + temp.rating);
                temp = temp.next;
            }
        }

        // Reverse display
        void reverse() {
            Node temp = tail;

            while (temp != null) {
                System.out.println(temp.title);
                temp = temp.prev;
            }
        }

        public static void main(String[] args) {
            MovieManagementSystem m = new MovieManagementSystem();

            m.insertFirst("Avatar", "James", 2022, 9.0);
            m.insertEnd("Titanic", "Cameron", 1997, 8.5);
            m.insertAt(2, "Jawan", "Atlee", 2023, 8.0);

            System.out.println("Forward:");
            m.forward();

            System.out.println("Reverse:");
            m.reverse();

            m.search("James");
            m.update("Avatar", 9.5);
            m.delete("Titanic");
        }
}
