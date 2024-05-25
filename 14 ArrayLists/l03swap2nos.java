import java.util.*;

public class l03swap2nos {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(7);

        System.out.println("Before Swapping araylist :" + list);
        swap(list, 1, 3);
        System.out.println("Swapped araylist         :" + list);

    }

    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j)); // using set() property of ArrayList
        list.set(j, temp); // using set() property of ArrayList
    }
}
