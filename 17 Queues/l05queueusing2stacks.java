import java.util.*;

public class l05queueusing2stacks {
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            // remove from 1st stack & send it to another stack
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // add the data in 1st stack
            s1.push(data);

            // now push back everything from 2nd to 1st stack
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int remove() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
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

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
