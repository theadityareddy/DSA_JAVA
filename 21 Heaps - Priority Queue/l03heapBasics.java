import java.util.*;

public class l03heapBasics {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int n){ // O(log n)
            // Step 1 : add to last index                 O(1)
            arr.add(n);

            // Step 2 : fix the array                   O(log n)
            int x = arr.size() - 1; // child location
            int par = (x-1)/2; // parent location

            // (1) if we change the sign below to make it descending order 
            while (arr.get(x) < arr.get(par)) {
                // swap child and parent
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // update indexes 
                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){ // O(1)
            return arr.get(0);
        }

        // to remove first element form heap
        public int remove() { // O(log n) : as heapify is takes log n time i.e. height of tree/heap
            int data = arr.get(0);

            // step 1 swap 1st element and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 delete the last node
            arr.remove(arr.size() - 1);

            // step 3 fix the heap
            heapify(0);

            return data;
        }

        private void heapify(int i) { // O(log n)
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i; // considering it as a min indx

            // rearringing the root, left child, and right child
            // also check weather our left child or right chile exist or not

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) { // (2) if we change the sign here to make it decending order
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) { // (3) if we change the sign here to make it decending order
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // now if the below tree also got jumbled up so we perform recurssion
                heapify(minIdx);
            }

        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek()); // 3 changes can reverse priority (check out the comments)
            h.remove();
        }
    }
}
