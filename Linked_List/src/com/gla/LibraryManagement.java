package com.gla;

public class LibraryManagement {
        static class Node {
            String title, author, genre, status;
            int id;

            Node prev, next;

            Node(String t, String a, String g, int i, String s) {
                title = t;
                author = a;
                genre = g;
                id = i;
                status = s;
            }
        }

        Node head = null, tail = null;

        // Insert at beginning
        void insertFirst(String t, String a, String g, int id, String s) {
            Node n = new Node(t, a, g, id, s);

            if (head == null) {
                head = tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
        }

        // Insert at end
        void insertEnd(String t, String a, String g, int id, String s) {
            Node n = new Node(t, a, g, id, s);

            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                n.prev = tail;
                tail = n;
            }
        }

        // Insert at position
        void insertAt(int pos, String t, String a, String g, int id, String s) {
            if (pos <= 1) {
                insertFirst(t, a, g, id, s);
                return;
            }

            Node temp = head;

            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null) return;

            if (temp == tail) {
                insertEnd(t, a, g, id, s);
                return;
            }

            Node n = new Node(t, a, g, id, s);
            n.next = temp.next;
            n.prev = temp;

            temp.next.prev = n;
            temp.next = n;
        }

        // Delete by ID
        void delete(int id) {
            Node temp = head;

            while (temp != null) {
                if (temp.id == id) {

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

        // Search by title
        void searchTitle(String title) {
            Node t = head;

            while (t != null) {
                if (t.title.equalsIgnoreCase(title))
                    System.out.println(t.author);

                t = t.next;
            }
        }

        // Search by author
        void searchAuthor(String author) {
            Node t = head;

            while (t != null) {
                if (t.author.equalsIgnoreCase(author))
                    System.out.println(t.title);

                t = t.next;
            }
        }

        // Update status
        void update(int id, String status) {
            Node t = head;

            while (t != null) {
                if (t.id == id) {
                    t.status = status;
                    return;
                }
                t = t.next;
            }
        }

        // Forward display
        void forward() {
            Node t = head;

            while (t != null) {
                System.out.println(t.title + " " +
                        t.author + " " + t.id + " " + t.status);

                t = t.next;
            }
        }

        // Reverse display
        void reverse() {
            Node t = tail;

            while (t != null) {
                System.out.println(t.title);
                t = t.prev;
            }
        }

        // Count books
        void count() {
            int c = 0;
            Node t = head;

            while (t != null) {
                c++;
                t = t.next;
            }

            System.out.println("Total Books: " + c);
        }

        public static void main(String[] args) {
            LibraryManagement l = new LibraryManagement();

            l.insertFirst("Java", "James", "Programming", 1, "Available");
            l.insertEnd("Python", "Guido", "Programming", 2, "Issued");
            l.insertAt(2, "DSA", "Mark", "Computer", 3, "Available");

            System.out.println("Forward:");
            l.forward();

            System.out.println("Reverse:");
            l.reverse();

            l.searchTitle("Java");
            l.update(2, "Available");
            l.delete(1);
            l.count();
        }
}
