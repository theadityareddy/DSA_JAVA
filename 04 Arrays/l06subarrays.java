import java.util.Scanner;

public class l06subarrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={2,4,6,8,10};
        subarray(a);
        in.close();
    }

    public static void subarray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j=i;j<a.length;j++){
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k]+" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// Time Complexity is O(n^3) : Since we are traversing/bruteforcing through each n every possible solution.