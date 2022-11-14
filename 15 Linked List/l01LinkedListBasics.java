public class l01LinkedListBasics {
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
    public static int size; // by default it'll be 0... inc while adding & dec while removing

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAnywhere(int index, int data){
        if (head == null){
            addFirst(data);
            return;
        }

        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i =1;
        while (i<index){ // temp will be my previous node
            temp = temp.next;
            i++;
        }

        // i = index -1 & temp = previous node
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public int deleteFirst(){
        if (head == null){
            return Integer.MIN_VALUE;
        } 
        else if (size == 1){
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast(){
        if (size == 0){
            return Integer.MIN_VALUE;
        } 
        else if (size == 1){
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for (int i=0; i<size-2;i++){
            prev = prev.next;
        }
        // we are at one before tail
        int val = prev.next.data;
        prev.next =null;
        tail = prev;
        size--;
        return val;
    }

    public void printLinkedList(Node head){ // O(n)
        if (head == null){
            System.out.println("null");
        }

        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }

    public static int iterativeSearch(int key){ // O(n)
        Node temp = head;
        int i = 0;
        while (temp != null){
            if (temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int recurssiveSearch(int key){ // Tc = Sc = O(n)
        return helper(head, key);
    }

    public static int helper(Node head, int key) { // O(n)
        //base case
        if (head.next == null){
            return -1;
        }
        // recurssion
        if (head.data == key){
            return 0;
        }
        if (helper(head.next, key) != -1){
            return helper(head.next, key)+1;
        }
        return -1;
    }

    public void reverseLinkedList(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // after while loop ends, update head -> prev = last, curr =null
        head = prev;
    }

    public void deleteNthNodeFromEnd(int n){
        // calculate size of LinkedList
        int sz =0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }

        // if n = size : remove first element
        if (n == sz){
            head = head.next; // like removeFirst
            return;
        }
        // for n : sz-n will give previous and we'll do the following
        int i = 1;
        Node prev = head;
        while (i < sz-n){
            prev = prev.next;
            i++;
        }
        //prev is pointing to previous
        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {
        l01LinkedListBasics ll = new l01LinkedListBasics();

        // add first
        ll.addFirst(2);
        ll.addFirst(1);

        // last first
        ll.addLast(3);
        ll.addLast(4);

        // add anywhere
        ll.addAnywhere(2, 10);

        // Iterative Search... Find key 
        System.out.println("Your key(3) is at "+ iterativeSearch(3));

        // Recurssive Search... Find key
        System.out.println("Your key(10) is at "+ recurssiveSearch(11));

        // // delete first
        // ll.deleteFirst();

        // // delete last
        // ll.deleteLast();

        // print the list
        ll.printLinkedList(head);
        System.out.println("Size of LinkedList is = "+size);

        // reverse linked list
        ll.reverseLinkedList();
        ll.printLinkedList(head);

        // delete Nth node from behind
        ll.deleteNthNodeFromEnd(2);
        ll.printLinkedList(head);
    }
}