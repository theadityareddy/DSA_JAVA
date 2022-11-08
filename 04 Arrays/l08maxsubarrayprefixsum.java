import java.util.Scanner;

public class l08maxsubarrayprefixsum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={1,-2,6,-1,3};
        maxsubarraybrute(a);
        in.close();
    }

    public static void maxsubarraybrute(int[] a) {
        int currentsum=0;
        int maxsum=Integer.MIN_VALUE;
        int prefixarr[]=new int[a.length]; // {1,-1, 5, 4, 7}
        prefixarr[0]=a[0];
        for (int i = 1; i < a.length; i++) {
            prefixarr[i]=prefixarr[i-1] + a[i];
            System.out.println(prefixarr[i]);
        }

        for (int i = 0; i < a.length; i++) {
            for (int j=i;j<a.length;j++){
                currentsum=(i==0) ? prefixarr[j] : prefixarr[j]-prefixarr[i-1];
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

// Time Complexity is O(n^2) : Since we removed the 3rd nested loop, our time complexity reduced.