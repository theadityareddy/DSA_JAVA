import java.util.Scanner;

public class p2invertrotatedhalfpyra {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no of rows for your pattern");
        int r = in.nextInt();
        pattern(r);
        in.close();
    }

    public static void pattern(int r) {
        for (int i = 1; i <= r ; i++) {
            for(int k=1; k<=r-i;k++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
