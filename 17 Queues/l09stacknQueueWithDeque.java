import java.util.*;

public class l09stacknQueueWithDeque {
    static class Stack{
        Deque <Integer> deque = new LinkedList<>();

        public boolean isEmpty(){
            return deque.isEmpty();
        }

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }
    }

    static class Queue{
        Deque <Integer> deque = new LinkedList<>();

        public boolean isEmpty(){
            return deque.isEmpty();
        }

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        Queue q = new Queue();

        // forStack
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        } 
        System.out.println();

        // forQueue
        q.add(1);
        q.add(3);
        q.add(5);
        
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}