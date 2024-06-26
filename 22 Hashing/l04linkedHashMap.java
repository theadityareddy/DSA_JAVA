import java.util.LinkedHashMap;

public class l04linkedHashMap {
    public static void main(String[] args) {
        // linked hashmap - O(1)
        // stores in the same order of insertion
        // implemented using doubly linked list
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        
        // insert - O(1)
        hm.put("Canada", 30);
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);

        System.out.println(hm);
    }
}
