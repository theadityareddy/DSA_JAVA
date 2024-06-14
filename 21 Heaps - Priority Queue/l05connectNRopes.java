import java.util.*;

public class l05connectNRopes {
    public static void main(String[] args) {
        int[] ropes = {2, 6, 3, 4, 3};

        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int minRope1 = pq.remove();
            int minRope2 = pq.remove();

            cost += minRope1 + minRope2;
            pq.add(minRope1 + minRope2);
        }

        System.out.println("The cost to join all the ropes is " + cost); // Time complexity : O(n)
    }
}
