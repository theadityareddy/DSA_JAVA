import java.util.TreeMap;

public class l05treeMapBasics {
    public static void main(String[] args) {
        // tree map
        // sorts based on key 
        // put, get, remove are O(log n)
        // implemented using red-black trees (self balancing trees)
        TreeMap <String, Integer> tm = new TreeMap<>();

        // insert - O(1)
        tm.put("Canada", 30);
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("USA", 50);

        System.out.println(tm);
    }
}
