import java.util.*;

public class l07slidingWindowMaximum {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p2){
            // decending order
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; //window size for the problem

        // we'll store (n-k+1) number of results for our sliding window problem
        int[] result = new int[arr.length-k+1]; 
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // perform for 1st window manually
        for (int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }
        result[0] = pq.peek().val;

        // do the same for remaining in the loop
        for (int i=k; i<arr.length; i++){
            // remove element at top of PQ that isn't part of the current window i.e. (i-k+1)
            while (!pq.isEmpty() && pq.peek().idx < (i-k+1)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));

            // add max in current window
            result[i-k+1] = pq.peek().val;
        }

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
