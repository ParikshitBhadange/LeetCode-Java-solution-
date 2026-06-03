// Here I write following code 
// 1. creation of linkedlist 
// 2. Add first in linkedlist
// 3. Add last in linkedlist
// 4. Add at given index in linkedlist
// 5. remove first from linkedlist
// 6. remove last from linkedlist
// 7. remove nth node from the end in linkedlist
// 8. tTwo searching methods :- a. Iterative Search 
//                              b. Recursive Search 
// 9. Printing linkelist

// Suggestion:- write main function by your own for each and every method return in the code to understand it workinh properly and always use written printll() method to print the linkelist 


public class Linkedlist {

    // Creating Linkelist from scratch
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

    // Adding the Node at the beginning of the Linkedlist
    // Time complexity is constant O(1)
    public void AddFirst(int data) {
        // Step 1:- Create new node to add in list
        Node newNode = new Node(data);
        size++;

        // if their is no node then head and tail of the list become new node after
        // creation (Single node in list)
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2:- next pointer of new node points to the head of the next node
        newNode.next = head;

        // step 3:- Update the head with the new node head in list
        head = newNode;
    }

    // Adding the Node at the end of the Linkedlist
    // Time complexity is constant O(1)
    public void AddLast(int data) {
        // Step 1:- Create new node to add in list
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2:- next pointer of new node points to the head of the previous node
        tail.next = newNode;

        // step 3:- Update the next pointer with the new node tail in list
        tail = newNode;
    }

    // Adding element at the indext in linkedlist
    public void Add(int idx, int data) {
        // Base condition fro the liskedlist
        if (idx == 0) {
            AddFirst(data);
            return;
        }

        // step 1:- Create new node to add in linkedlist
        Node newNode = new Node(data);
        size++;

        // step 2:- create temporary varibale to store the values to insert the new node
        // at specific index
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // step 3:- after reaching the desired index insert the node (i = idx-1, temp ->
        // prev)
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove node from the beginning of the linkedlist
    public int removefirst() {
        if (size == 0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove node from the end of the linkedlist
    public int removelast() {
        if (size == 0) {
            System.out.println("Linledlist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // previous node :- i = size -2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }



        // Find and remove Nth node from the end
    public void deleteNfromEnd(int n) {
        // Calculate the size of the linkedlist

        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (n == size) {
            head = head.next; // remove first
            return;
        }

        // reach at the size-n node

        int i = 1;
        int iTofind = size - n;

        Node prev = head;

        while (i < iTofind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }



    

    // Iterative search into the list:- searching key value one by on ein list
    public int ItrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                // key is found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return -1;
    }

    // Recursive search into the list:- searching key value using recursion method
    // and use backtrsacking to get original output

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recsearch(int key) {
        return helper(head, key);
    }

    // Reversing the linkedlist
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }




    

    // Printing the linkedlist
    // Time Complexity is O(n)
    public void printll() {
        // declare temporary variable to copy the data from linkedlist to perform
        // operatin without disturbing the linkedlist
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        // ll.printll();
        ll.AddFirst(2);
        // ll.printll();
        ll.AddFirst(1);
        // ll.printll();
        ll.AddLast(3);
        // ll.printll();
        ll.AddLast(4);
        ll.printll();

        System.out.println("Inserting element at specific index");
        ll.Add(2, 9);
        ll.printll();

        System.out.println("Remove from the beginning of the list");
        ll.removefirst();
        ll.printll();

        System.out.println("Remove from the end of the list");
        ll.removelast();
        ll.printll();

        System.out.println("Size of the linkelist is: " + ll.size);

        System.out.println("Iterative search call");
        System.out.println(ll.ItrSearch(3));
        System.out.println(ll.ItrSearch(10));

        System.out.println("Recursive search call");
        System.out.println(ll.ItrSearch(3));
        System.out.println(ll.ItrSearch(10));

        System.out.println("Reversing the linkedlist");
        ll.reverse();
        ll.printll();

        // System.out.println("New linkedlist is:-");
        // ll.AddFirst(1);
        // ll.AddFirst(2);
        // ll.AddFirst(3);
        // ll.AddFirst(4);
        // ll.AddFirst(5);
        // ll.printll();

        System.out.println("Removing node from the nth position");
        ll.deleteNfromEnd(3);
        ll.printll();

    }
}