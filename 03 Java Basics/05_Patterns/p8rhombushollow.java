import java.util.Scanner;

public class p8rhombushollow {
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
                System.out.print("   ");
            }
            for (int j=1; j<=n;j++){
                if ( i==1 || i==n || j==1 || j==n){
                    System.out.print("*  ");
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}