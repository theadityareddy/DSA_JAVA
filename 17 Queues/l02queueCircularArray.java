public class l02queueCircularArray {
    static class Queue{
        static int arr[];
        static int front;
        static int rear;
        static int size;

        Queue(int n){
            arr = new int[n];
            front = -1;
            rear = -1;
            size=n;
        }

        public boolean isEmpty(){
            return (front == -1) && (rear == -1);
        }
 
        public boolean isFull(){
            return (rear+1)%size == front;
        }

        public void add(int data){
            if(isFull()){
                System.out.println("the queue is full");
                return;
            }
            if (front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("the queue is empty");
                return -1;
            }
            int val = arr[front];
            front = (front+1)%size;
            if ((rear+1%size) == front){
                rear = front = -1;
            }
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("the queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(10);
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
