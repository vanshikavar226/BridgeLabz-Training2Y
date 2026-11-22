package com.gla;

public class TextEditorUndoRedo {
        static class Node {
            String text;
            Node prev, next;

            Node(String t) {
                text = t;
            }
        }

        Node head = null, current = null;

        int count = 0;
        int limit = 10;

        // Add new text state
        void addState(String text) {

            Node n = new Node(text);

            if (head == null) {
                head = current = n;
                count = 1;
                return;
            }

            // Remove redo history
            current.next = null;

            n.prev = current;
            current.next = n;
            current = n;

            count++;

            // Limit history to 10 states
            if (count > limit) {
                head = head.next;
                head.prev = null;
                count--;
            }
        }

        // Undo
        void undo() {
            if (current != null && current.prev != null) {
                current = current.prev;
            } else {
                System.out.println("Nothing to Undo");
            }
        }

        // Redo
        void redo() {
            if (current != null && current.next != null) {
                current = current.next;
            } else {
                System.out.println("Nothing to Redo");
            }
        }

        // Display current text
        void display() {
            if (current != null)
                System.out.println("Current Text: " + current.text);
            else
                System.out.println("Empty");
        }

        public static void main(String[] args) {
            TextEditorUndoRedo t = new TextEditorUndoRedo();

            t.addState("Hello");
            t.addState("Hello World");
            t.addState("Hello World Java");

            t.display();

            System.out.println("Undo:");
            t.undo();
            t.display();

            System.out.println("Redo:");
            t.redo();
            t.display();

            t.addState("Hello Java");
            t.display();
        }
}
