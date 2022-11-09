import java.util.ArrayList;

public class l02findMax {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(7);

        for (int i = 0; i<list.size() ; i++){
            max = Math.max(list.get(i), max);
        }

        System.out.println("The max no in array list is " + max);
    }
}
