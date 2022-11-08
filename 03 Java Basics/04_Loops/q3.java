import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to find factorial");
        int n=in.nextInt();
        int fact=1;
        for (int i=1; i<=n; i++)
        {
            fact*=i;
        }
        System.out.println("the factorial of "+n+" is "+fact);
        in.close();
    }
}
