import java.util.*;

public class l02iterationOnHashMap {
    public static void main(String[] args) {
        // create HashMap
        HashMap <String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Indonesia", 5);
        hm.put("Nepal", 3);

        // iterate
        Set<String> keys = hm.keySet();

        for(String key : keys){
            System.out.print("key -> " + key);
            System.out.println(", value -> " + hm.get(key));
        }
    }
}
