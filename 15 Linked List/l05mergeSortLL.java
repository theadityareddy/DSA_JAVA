public class l05mergeSortLL {
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

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node slow = head;
        Node fast = head.next;
        // so that in even array list we get 1st mid (last part of first half) and not
        // 2nd mid (first part of second half)

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node mid = slow;

        // dividing in small parts
        Node leftHalf = head;
        Node rightHalf = mid.next;
        mid.next = null;

        // merge
        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private static Node merge(Node leftHalf, Node rightHalf) {
        // temp LL
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        // sort the two halves
        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.data <= rightHalf.data) {
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
                temp = temp.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
                temp = temp.next;
            }
        }

        while (leftHalf != null) {
            temp.next = leftHalf;
            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        // return merged LL
        return mergedLL.next;
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
        l05mergeSortLL ll = new l05mergeSortLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        printLinkedList(head);
        printLinkedList(mergeSort(head));
    }
}
