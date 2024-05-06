import java.util.*;

public class l01priorityQueueJCF {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(9);
        pq.add(1);
        pq.add(6);
        pq.add(11);

        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}