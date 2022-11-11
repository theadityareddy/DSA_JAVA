import java.util.*;

public class l06pairSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1, 2, 3, 4, 5 - SORTED arrayList
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Target = 05 : " + findSum1(list, 5));
        System.out.println("Target = 50: " + findSum1(list, 50));
    }

    public static Boolean findSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size()-1;

        while (lp<rp){
            if (list.get(lp)+list.get(rp) == target){
                return true;
            } 
            else if (list.get(lp)+list.get(rp) < target){
                lp++;
            }
            else {
                rp--;
            }
        }

        return false;
    }
}
