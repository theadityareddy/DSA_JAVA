public class l07doublyLinkedList {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void printDLL(Node head) {
        if (head == null) {
            System.out.println("null");
        }
        if (head.next == null) {
            System.out.print(head.data + "<->");
        }
        while (head != null) {
            System.out.print(head.data + "<->");
            head = head.next;
        }
        System.out.print("null\n");
    }

    public void reverseLL() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        l07doublyLinkedList dll = new l07doublyLinkedList();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.printDLL(head);
        dll.reverseLL();
        dll.printDLL(head);
    }
}