package com.gla;

public class CustomHashMap {
        static class Node {
            int key, value;
            Node next;

            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        Node table[] = new Node[10];

        // Insert
        void put(int key, int value) {

            int index = key % 10;

            Node temp = table[index];

            while (temp != null) {

                if (temp.key == key) {
                    temp.value = value;
                    return;
                }

                temp = temp.next;
            }

            Node n = new Node(key, value);

            n.next = table[index];

            table[index] = n;
        }

        // Get
        int get(int key) {

            int index = key % 10;

            Node temp = table[index];

            while (temp != null) {

                if (temp.key == key) {
                    return temp.value;
                }

                temp = temp.next;
            }

            return -1;
        }

        // Delete
        void remove(int key) {

            int index = key % 10;

            Node temp = table[index];

            Node prev = null;

            while (temp != null) {

                if (temp.key == key) {

                    if (prev == null) {
                        table[index] = temp.next;
                    } else {
                        prev.next = temp.next;
                    }

                    return;
                }

                prev = temp;
                temp = temp.next;
            }
        }

        public static void main(String[] args) {

            CustomHashMap map = new CustomHashMap();

            map.put(1, 100);
            map.put(2, 200);
            map.put(3, 300);

            System.out.println(map.get(1));
            System.out.println(map.get(2));

            map.remove(2);

            System.out.println(map.get(2));
        }
}
