import java.util.Scanner;

public class l3_binomialcoff {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("calculate binomial coefficient");
        System.out.println("enter n");
        int n= in.nextInt();
        System.out.println("enter c");
        int r= in.nextInt();
        int ncr = fact(n)/(fact(r)*fact(n-r));
        System.out.println("nCr is "+ncr);
        in.close();
    }

    public static int fact(int n) {
        int f=1;
        for (int i=1;i<=n;i++)
        {
            f*=i;
        }
        return f;
    }
}
