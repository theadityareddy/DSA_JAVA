import java.util.*;

public class l07maxsubarraysumbrute {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={1,-2,6,-1,3};
        maxsubarraybrute(a);
        in.close();
    }

    public static void maxsubarraybrute(int[] a) {
        int currentsum=0;
        int maxsum=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j=i;j<a.length;j++){
                currentsum=0;
                for (int k = i; k <= j; k++) {
                    // System.out.print(a[k]+" ");
                    currentsum+=a[k];
                }
                System.out.print(currentsum+" ");
                if (maxsum<currentsum){
                    maxsum=currentsum;
                }
            }
            System.out.println();
        }
        System.out.println("Max sum of subarray is "+maxsum);
    }
}

// Time Complexity is O(n^3) : Since we are traversing/bruteforcing through each n every possible solution.