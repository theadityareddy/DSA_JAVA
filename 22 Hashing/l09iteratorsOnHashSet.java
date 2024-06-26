import java.util.*;

public class l09iteratorsOnHashSet {
    public static void main(String[] args) {
        HashSet <Integer> numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(1);

        // 1. with Iterators
        @SuppressWarnings("rawtypes") // suppressing warnings
        Iterator itr = numbers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();

        // 2. advanced for loop
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
