import java.util.Scanner;

public class l09maxsubarraykadanesalgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int a[]={-2,-3,4,-1,-2,1,5,-3};
        int a[]={-2,-7,-19,-4,-9,-10};
        maxsubarraykadanes(a);
        in.close();
    }

    public static void maxsubarraykadanes(int[] a) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE; // for maximum sum
        int maxneg = Integer.MIN_VALUE; // when all values are neg

        for(int i=0;i<a.length;i++){
            currsum += a[i];
            if (currsum<0){ // if curr cum becomes neg, make it pos
                currsum=0;
            }
            maxneg=Math.max(maxneg, a[i]); // sum of neg no will be smaller, therefore we find max neg no of array
            maxsum=Math.max(maxsum, currsum);
        }
        if (maxsum>0){ 
            System.out.println(maxsum);
        } else {
            System.out.println(maxneg);
        }
    }
}
