// This code shows the doublely linkelist reprsentation, addFirst() method, removeFirst() method


public class DoubleLL {

    // creating Doublely Linkedlist
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    // Adding node at beginning of the Linkedlist
    // same for adding at last 
    public void addfirst(int data){
        // Create New node
       Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    // Remove from the beginning of the doublely linkedlist 
    // same for remove from last
    public int removefirst(){
        if (head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
         size--;
         return val;
    }


    // Printing doublely Linkedlist 
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();

        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        dll.print();
        System.out.println("Size of doublely linke list is " + dll.size);
        dll.removefirst();
        dll.print();
         System.out.println("Size of doublely linke list is " + dll.size);

    }
}


