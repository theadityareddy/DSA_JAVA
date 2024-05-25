public class l02checkLLisPalindrome {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printLinkedList(Node temp) {
        if (temp == null) {
            System.out.print("null");
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node findMid(Node head) { // helper func for palindrome - slowFastApproach
        Node slow = head; // +1
        Node fast = head; // +2
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1. find mid
        Node mid = findMid(head);

        // 2. rotate 2nd half of linked list
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 3. Compare 1st half and 2nd half
        Node left = head;
        Node right = tail;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        l02checkLLisPalindrome ll = new l02checkLLisPalindrome();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLinkedList(head);
        System.out.println(isPalindrome(head));
    }
}