// Detecting the cycle & removing it from  linkedlist

// use Slow & Fast pointer/ Tortoise and Hare method



public class CycleLL {

    // linked list declaration
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Detecting Cycle linked list using Floyd's Cycle Finding Algorithm
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move 1 step or node
            fast = fast.next.next; // move 2 stepas or nodes

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Removing the cycle in linkedlist
    public static void removeCycle() {

        // detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;  //last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove Cycle -> last.next = null
        prev.next = null;
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }

}

