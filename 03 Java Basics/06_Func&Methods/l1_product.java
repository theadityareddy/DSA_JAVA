import java.util.Scanner;

public class l1_product{
    public static int product(int a, int b) {
        int prod = a*b;
        return prod;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter 1st no ");
        int a = in.nextInt();
        System.out.println("enter 2nd no ");
        int b = in.nextInt();
        int product = product(a,b);
        System.out.println("the product is "+product);
        in.close();
    }
}