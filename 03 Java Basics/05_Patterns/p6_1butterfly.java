import java.util.Scanner;

public class p6_1butterfly {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter rows per triangle");
        int n = in.nextInt();
        System.out.println();
        pattern(n);
        in.close();
    }

    public static void pattern(int n) {
        for( int i=1;i<=n;i++)
        {
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }
            for (int k=1; k<=(n-i); k++){
                System.out.print("  ");
            }

            for (int k=1; k<=(n-i); k++){
                System.out.print("  ");
            }
            for (int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for( int i=n;i>=1;i--)
        {
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }
            for (int k=1;k<=(n-i);k++){
                System.out.print("  ");
            }
            
            for (int k=1;k<=(n-i);k++){
                System.out.print("  ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}