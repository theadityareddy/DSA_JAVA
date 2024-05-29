import java.util.*;

public class l08queueReversal {
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        // queue to stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        // stack to queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverseQueue(q);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}