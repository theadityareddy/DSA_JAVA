import java.util.Scanner;

public class p4floyedstriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no of rows");
        int r = in.nextInt();
        pattern(r);
        in.close();
    }

    public static void pattern(int n) {
        int k=1;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println();
        }
    }
}
