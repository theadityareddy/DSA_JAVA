import java.util.HashMap;

public class l01hashMapBasics {
    public static void main(String[] args) {
        // create HashMap
        HashMap <String, Integer> hm = new HashMap<>();

        // insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);

        // get - O(1)
        int population = hm.get("India"); // if KEY present -> value
        System.out.println(population);
        System.out.println(hm.get("Pakistan")); // if KEY not present -> null

        // containsKey - O(1)
        System.out.println(hm.containsKey("USA")); // returns boolean
        System.out.println(hm.containsKey("Canada"));

        // remove - O(1)
        int populationOfDeletedValue = hm.remove("China"); // returns value
        System.out.println(populationOfDeletedValue);
    }
}
