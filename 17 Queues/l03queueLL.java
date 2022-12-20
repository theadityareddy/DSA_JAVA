public class l03queueLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{
        Node head;
        Node tail;

        public boolean isEmpty(){
            return head == null && tail == null;
        }

        public void add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("the queue is empty");
                return -1;
            }
            int val = head.data;
            if (head == tail){
                head = tail = null;
                return val;
            }
            head = head.next;
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("the queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(3);
        q.add(5);
        System.out.println("removed: " + q.remove());
        q.add(7);
        System.out.println("removed: " + q.remove());
        q.add(9);
        
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
