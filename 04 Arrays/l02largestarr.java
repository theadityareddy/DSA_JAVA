import java.util.Scanner;

public class l02largestarr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={2,4,5,8,12,23,31,38};
        System.out.println("the largest no is " + largest(a));
        in.close();
    }

    public static int largest(int[] a) {
        int l = Integer.MIN_VALUE;
        for (int i=1; i<a.length;i++){
            if(a[i]>l){
                l=a[i];
            }
        }
        return l;
    }
}

// Time Complexity is O(n)