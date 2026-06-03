// in zig zag linkedlist 1st node connect with nth node , 2nd node connect with n-1 node, 3rd node connect with n-2 node,.......
// Example:- Normal linkelist   1->2->3->4->5
//           ZigZag linkelist   1->5->2->4->3


public class ZigZagMerge {

    // Node class
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

    // Add node at beginning
    public void AddFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Print Linked List
    public void printll() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("Null");
    }

    // Zig Zag Merge
    public void zigzag() {
        // find mid

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node lefthead = head;
        Node righthead = prev;
        Node nextL, nextR;

        // alternate merge - zigzag merge

        while (lefthead != null && righthead != null) {
            nextL = lefthead.next;
            lefthead.next = righthead;
            nextR = righthead.next;
            righthead.next = nextL;

            // update
            lefthead = nextL;
            righthead = nextR;

        }
    }

    public static void main(String[] args) {
        ZigZagMerge ll = new ZigZagMerge();

        ll.AddFirst(5);
        ll.AddFirst(4);
        ll.AddFirst(3);
        ll.AddFirst(2);
        ll.AddFirst(1);

        ll.printll();
        ll.zigzag();
        ll.printll();
    }

}
