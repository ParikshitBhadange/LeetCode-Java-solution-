// Merge sort on linkelist
//  divide linkedlist into two parts using mid() method
// sort them & merge them using merge() method 


public class LLMergeSort {

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
    public static int size;


    // Add node at beginning
    public void AddFirst(int data) {

        Node newNode = new Node(data);
        size++;

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



    // Find Mid
    private Node getMid(Node head) {

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    // Merge two sorted linked lists
    private Node merge(Node head1, Node head2) {

        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {

                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;

            } else {

                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        // Remaining nodes of head1
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // Remaining nodes of head2
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }



    // Main Merge Sort 
    public Node MergeSort(Node head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid
        Node mid = getMid(head);

        // Divide list
        Node rightHead = mid.next;
        mid.next = null;

        // Recursive sort
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(rightHead);

        // Merge
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {

        LLMergeSort ll = new LLMergeSort();

        ll.AddFirst(1);
        ll.AddFirst(5);
        ll.AddFirst(2);
        ll.AddFirst(4);
        ll.AddFirst(3);

        System.out.println("Original Linked List:");
        ll.printll();

        ll.head = ll.MergeSort(ll.head);

        System.out.println("\nSorted Linked List:");
        ll.printll();
    }
}


