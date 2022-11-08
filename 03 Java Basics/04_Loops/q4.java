import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to print its table");
        int n = in.nextInt();

        for (int i=1;i<=10;i++)
        {
            System.out.println(i + " x " + n + " = " + (i*n));
        }
        in.close();
    }
}
