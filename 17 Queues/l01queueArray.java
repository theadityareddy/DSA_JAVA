public class l01queueArray {
    static class Queue {
        static int arr[];
        static int rear;
        static int size;

        Queue(int n) {
            arr = new int[n];
            rear = -1;
            size = n;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) { // O(1) - also called Enque
            if (rear == size - 1) {
                System.out.println("the queue is full");
                return;
            }
            arr[++rear] = data;
        }

        public int remove() { // O(n) - also called Dequeue (Deque is different : Double ended queue)
            if (rear == -1) {
                System.out.println("the queue is empty");
                return -1;
            }
            int val = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return val;
        }

        public int peek() { // O(1)
            if (rear == -1) {
                System.out.println("the queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(1);
        q.add(3);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
