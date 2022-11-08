import java.util.Scanner;

public class l2_fact {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("enter no");
        int n= in.nextInt();
        int fact=fact(n);
        System.out.println("factrial of your no is "+fact);
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
