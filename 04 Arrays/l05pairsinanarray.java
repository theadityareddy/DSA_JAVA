import java.util.Scanner;

public class l05pairsinanarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a[]={2,4,6,8,10};
        pairs(a);
        in.close();
    }

    public static void pairs(int[] a) {
        int totalpairs = 0;
        for (int i=0; i<=a.length-1; i++){
            for (int j=i+1;j<a.length; j++){
                System.out.print("( " + a[i] + " , " + a[j] + " ) ");
                totalpairs++;
            }
            System.out.println();
        }
        System.out.println("total pairs are "+totalpairs);
    }
}

// TimeComplexity is O(n^2) : coz of nested loop, coz in worst case it'll go i for n-times and j will go n-times
