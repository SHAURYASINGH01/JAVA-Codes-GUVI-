Ques 2
import java.util.Scanner;

// The public class should be named Main and match the filename Main.java
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu to the user
        int choice = scanner.nextInt();

        if (choice == 1) {
            // CustomLinkedList operations
            CustomLinkedList linkedList = new CustomLinkedList();

            for (int i = 0; i < 3; i++) {
                linkedList.add(scanner.nextInt());
            }
            scanner.nextLine(); // Consume newline

            System.out.println("Linked List after additions:");
            linkedList.display();

            int removeIndex = scanner.nextInt();
            linkedList.remove(removeIndex);

            System.out.println("Linked List after removal:");
            linkedList.display();

            int getIndex = scanner.nextInt();
            System.out.println("Element at index " + getIndex + ": " + linkedList.get(getIndex));

            System.out.println("Size of the LinkedList: " + linkedList.size());

        } else if (choice == 2) {
            // CustomStack operations
            CustomStack stack = new CustomStack();

            for (int i = 0; i < 3; i++) {
                stack.push(scanner.nextInt());
            }

            System.out.println("Stack after pushes:");
            stack.display();

            System.out.print("Popped elements: ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                try {
                    sb.append(stack.pop()).append(" ");
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Print the result with a trailing space removed
            System.out.println(sb.toString().trim());

            System.out.println("Stack after pops:");
            stack.display();
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Inner class CustomLinkedList
    static class CustomLinkedList {
        private Node head;
        private int size;

        private class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public CustomLinkedList() {
            head = null;
            size = 0;
        }

        // Add element at the end
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // Remove element at specific index
        public void remove(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Index out of bounds.");
                return;
            }
            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
            }
            size--;
        }

        // Get element at specific index
        public int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        // Get size of the list
        public int size() {
            return size;
        }

        // Display the list
        public void display() {
            Node current = head;
            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.append(current.data);
                current = current.next;
                if (current != null) {
                    sb.append(" "); // Append space only if there's another node after the current one
                }
            }
            System.out.println(sb.toString());
        }
    }

    // Inner class CustomStack
    static class CustomStack {
        private CustomLinkedList list;

        public CustomStack() {
            list = new CustomLinkedList();
        }

        // Push element onto the stack
        public void push(int data) {
            list.add(data);
        }

        // Pop element from the stack
        public int pop() {
            if (list.size() == 0) {
                throw new IllegalStateException("Stack underflow.");
            }
            int data = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return data;
        }

        // Peek element from the stack
        public int peek() {
            if (list.size() == 0) {
                throw new IllegalStateException("Stack is empty.");
            }
            return list.get(list.size() - 1);
        }

        // Get size of the stack
        public int size() {
            return list.size();
        }

        // Display the stack
        public void display() {
            list.display();
        }
    }
}

