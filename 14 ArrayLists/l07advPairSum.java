import java.util.*;

public class l07advPairSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 11, 15, 6, 8, 9, 10 - SORTED arrayList
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println("Target = 16 : " + advPairSum(list, 16));
        System.out.println("Target = 11 : " + advPairSum(list, 11));
    }

    public static boolean advPairSum(ArrayList<Integer> list, int target) {
        int breakpoint = -1; //initalizing with invalid index
        int n = list.size();

        // find breakpoint
        for (int i=0; i<list.size(); i++){
            if (list.get(i) > list.get(i+1)){ // breakPoint
                breakpoint = i;
                break;
            }
        }

        // initalizing pointers for a ROTATED SORTED Array
        int lp = breakpoint+1; // smallest
        int rp = breakpoint; // largest

        while (lp != rp){
            if (list.get(lp)+list.get(rp) == target){
                return true;
            } 
            else if (list.get(lp)+list.get(rp) < target){
                lp = (lp+1) % n; //MODULO ARITHMATIC (using mod operator properties)
            }
            else { 
                rp = (rp+n-1) % n; //MODULO ARITHMATIC (using mod operator properties)
            }
        }

        return false;
    }
}
