import java.util.*;

public class l07chocolaProblem {
    public static void main(String[] args) {

        // This Question is available on platform called SPOJ...
        // COCOLA PROBLEM (Hard)

        // n = 4, m = 6;
        Integer costHor[] = { 4, 1, 2 }; // n-1
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1

        // sort the costs in dec order
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int hp = 1, vp = 1; // keeps count of the pieces
        int h = 0, v = 0; // pointers to traverse cost
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] >= costVer[v]) {
                // horizontal cut
                cost += vp * costHor[h];
                hp++;
                h++;
            } else {
                // vertical cut
                cost += hp * costVer[v];
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            // horizontal cut
            cost += vp * costHor[h];
            hp++;
            h++;
        }

        while (v < costVer.length) {
            // vertical cut
            cost += hp * costVer[v];
            vp++;
            v++;
        }

        System.out.println("The min cost to cut chocolate to all individual pieces is " + cost);
    }
}