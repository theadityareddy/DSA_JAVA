public class l06zigZagMergingLL {
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

    public static void alternateMerge(Node head) {
        // 1. find mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // 2. reverse LL
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = null;

        // 3. zig-zag : alternate LL
        Node left = head;
        Node right = tail;
        Node nextLeft, nextRight;

        while (left != null && right != null) {
            // zig-zag
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            // update head
            left = nextLeft;
            right = nextRight;
        }
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("null");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null \n");
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = tail = new Node(5);

        printLinkedList(head);
        alternateMerge(head);
        printLinkedList(head);
    }
}
