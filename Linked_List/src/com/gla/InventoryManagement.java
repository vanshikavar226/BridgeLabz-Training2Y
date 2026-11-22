package com.gla;

public class InventoryManagement {
        static class Node {
            String name;
            int id, quantity;
            double price;
            Node next;

            Node(String n, int i, int q, double p) {
                name = n;
                id = i;
                quantity = q;
                price = p;
            }
        }

        Node head = null;

        // Insert at beginning
        void insertFirst(String n, int id, int q, double p) {
            Node temp = new Node(n, id, q, p);
            temp.next = head;
            head = temp;
        }

        // Insert at end
        void insertEnd(String n, int id, int q, double p) {
            Node temp = new Node(n, id, q, p);

            if (head == null) {
                head = temp;
                return;
            }

            Node t = head;

            while (t.next != null)
                t = t.next;

            t.next = temp;
        }

        // Insert at position
        void insertAt(int pos, String n, int id, int q, double p) {
            if (pos <= 1) {
                insertFirst(n, id, q, p);
                return;
            }

            Node t = head;

            for (int i = 1; i < pos - 1 && t != null; i++)
                t = t.next;

            if (t == null) return;

            Node temp = new Node(n, id, q, p);
            temp.next = t.next;
            t.next = temp;
        }

        // Delete by ID
        void delete(int id) {
            if (head == null) return;

            if (head.id == id) {
                head = head.next;
                return;
            }

            Node t = head;

            while (t.next != null && t.next.id != id)
                t = t.next;

            if (t.next != null)
                t.next = t.next.next;
        }

        // Update quantity
        void update(int id, int q) {
            Node t = head;

            while (t != null) {
                if (t.id == id) {
                    t.quantity = q;
                    return;
                }
                t = t.next;
            }
        }

        // Search by ID
        void searchID(int id) {
            Node t = head;

            while (t != null) {
                if (t.id == id)
                    System.out.println(t.name);

                t = t.next;
            }
        }

        // Search by name
        void searchName(String name) {
            Node t = head;

            while (t != null) {
                if (t.name.equalsIgnoreCase(name))
                    System.out.println(t.id);

                t = t.next;
            }
        }

        // Total inventory value
        void totalValue() {
            double sum = 0;
            Node t = head;

            while (t != null) {
                sum += t.price * t.quantity;
                t = t.next;
            }

            System.out.println("Total Value: " + sum);
        }

        // Sort by price (ascending)
        void sort() {
            for (Node i = head; i != null; i = i.next) {
                for (Node j = i.next; j != null; j = j.next) {

                    if (i.price > j.price) {
                        String name = i.name;
                        i.name = j.name;
                        j.name = name;

                        int id = i.id;
                        i.id = j.id;
                        j.id = id;

                        int q = i.quantity;
                        i.quantity = j.quantity;
                        j.quantity = q;

                        double p = i.price;
                        i.price = j.price;
                        j.price = p;
                    }
                }
            }
        }

        void display() {
            Node t = head;

            while (t != null) {
                System.out.println(t.name + " " + t.id +
                        " " + t.quantity + " " + t.price);
                t = t.next;
            }
        }

        public static void main(String[] args) {
            InventoryManagement i = new InventoryManagement();

            i.insertFirst("Laptop", 1, 5, 50000);
            i.insertEnd("Mouse", 2, 10, 500);
            i.insertAt(2, "Keyboard", 3, 4, 1000);

            i.display();

            i.totalValue();
            i.searchID(1);
            i.update(2, 20);
            i.sort();

            System.out.println("After Sorting:");
            i.display();

            i.delete(3);
        }
}
