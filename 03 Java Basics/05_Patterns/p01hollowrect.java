import java.util.Scanner;

public class p01hollowrect {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter col & rows for the hollow rect pattern");
        int c= in.nextInt();
        int r = in.nextInt();
        pattern(r,c);
        in.close();
    }

    public static void pattern(int r, int c) {
        for (int i= 1; i <= r; i++){
            for (int j=1; j<=c;j++){
                if ( i==1 || i==r|| j==1 || j==c ){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
