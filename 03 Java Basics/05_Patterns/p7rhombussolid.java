import java.util.Scanner;

public class p7rhombussolid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no of rows");
        int n = in.nextInt();
        pattern(n);
        in.close();
    }

    public static void pattern(int n) {
        for ( int i=1;i<=n;i++){
            for (int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
            for (int j=1; j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
