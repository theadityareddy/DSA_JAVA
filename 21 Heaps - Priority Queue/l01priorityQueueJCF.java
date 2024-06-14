import java.util.*;

public class l01priorityQueueJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Using Heaps : implememented using ArrayList but visualised with trees
        pq.add(3); // O(log n)
        pq.add(9);
        pq.add(1);
        pq.add(6);
        pq.add(11);

        while (!pq.isEmpty()){
            System.out.print(pq.peek() + " "); // O(1)
            pq.remove(); // O(log n)
        }
    }
}