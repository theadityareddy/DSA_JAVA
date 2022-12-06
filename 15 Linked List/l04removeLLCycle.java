public class l04removeLLCycle {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node head;
    public static Node tail;

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL(Node temp){
        while (temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public static boolean isCircularLL(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public void removeLLCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // find if cycle is present
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                cycle = true;
                break;
            }
        }
        if (cycle == false){
            return;
        }

        // detect last
        Node prev = null;
        slow = head;
        while (slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;
    }
 
    public static void main(String[] args) {
        l04removeLLCycle ll = new l04removeLLCycle();
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(7);
        tail.next = head.next;
        System.out.println(isCircularLL(head));
        ll.removeLLCycle();
        System.out.println(isCircularLL(head));
    }
}