import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("enter no 1 : ");
        int n1 = in.nextInt();
        System.out.println("enter no 2 : ");
        int n2 = in.nextInt();
        System.out.println("enter no 3 : ");
        int n3 = in.nextInt();

        System.out.println("avg of the entered nos is "+avg(n1,n2,n3));
        in.close();
    }

    public static int avg(int n1, int n2, int n3) {
        int a = (n1+n2+n3)/3;
        return a;
    }
}
