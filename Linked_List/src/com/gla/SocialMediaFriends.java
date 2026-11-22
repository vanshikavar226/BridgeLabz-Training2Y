package com.gla;
import java.util.ArrayList;
public class SocialMediaFriends {
        static class Node {
            int id, age;
            String name;

            ArrayList<Integer> friends = new ArrayList<>();

            Node next;

            Node(int i, String n, int a) {
                id = i;
                name = n;
                age = a;
            }
        }

        Node head = null;

        // Add user
        void addUser(int id, String name, int age) {
            Node n = new Node(id, name, age);

            if (head == null) {
                head = n;
                return;
            }

            Node t = head;

            while (t.next != null)
                t = t.next;

            t.next = n;
        }

        // Find user
        Node find(int id) {
            Node t = head;

            while (t != null) {
                if (t.id == id)
                    return t;

                t = t.next;
            }

            return null;
        }

        // Add friend connection
        void addFriend(int id1, int id2) {
            Node u1 = find(id1);
            Node u2 = find(id2);

            if (u1 != null && u2 != null && id1 != id2) {
                if (!u1.friends.contains(id2))
                    u1.friends.add(id2);

                if (!u2.friends.contains(id1))
                    u2.friends.add(id1);
            }
        }

        // Remove friend
        void removeFriend(int id1, int id2) {
            Node u1 = find(id1);
            Node u2 = find(id2);

            if (u1 != null && u2 != null) {
                u1.friends.remove(Integer.valueOf(id2));
                u2.friends.remove(Integer.valueOf(id1));
            }
        }

        // Display friends
        void displayFriends(int id) {
            Node u = find(id);

            if (u != null)
                System.out.println(u.friends);
        }

        // Mutual friends
        void mutualFriends(int id1, int id2) {
            Node u1 = find(id1);
            Node u2 = find(id2);

            if (u1 == null || u2 == null) return;

            for (int id : u1.friends) {
                if (u2.friends.contains(id))
                    System.out.println("Mutual Friend: " + id);
            }
        }

        // Search by name
        void searchName(String name) {
            Node t = head;

            while (t != null) {
                if (t.name.equalsIgnoreCase(name))
                    System.out.println(t.id + " " + t.name);

                t = t.next;
            }
        }

        // Search by ID
        void searchID(int id) {
            Node t = find(id);

            if (t != null)
                System.out.println(t.name);
            else
                System.out.println("User Not Found");
        }

        // Count friends
        void countFriends() {
            Node t = head;

            while (t != null) {
                System.out.println(t.name + " Friends: " +
                        t.friends.size());

                t = t.next;
            }
        }

        public static void main(String[] args) {
            SocialMediaFriends s = new SocialMediaFriends();

            s.addUser(1, "Rahul", 20);
            s.addUser(2, "Aman", 21);
            s.addUser(3, "Priya", 19);
            s.addUser(4, "Riya", 20);

            s.addFriend(1, 2);
            s.addFriend(1, 3);
            s.addFriend(2, 3);
            s.addFriend(2, 4);

            System.out.println("Friends of Rahul:");
            s.displayFriends(1);

            System.out.println("Mutual Friends:");
            s.mutualFriends(1, 2);

            s.searchName("Priya");
            s.searchID(2);

            s.removeFriend(1, 2);

            s.countFriends();
        }
}
