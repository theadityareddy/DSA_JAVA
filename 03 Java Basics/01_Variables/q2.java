import java.util.Scanner;

public class q2 {
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter side of square to calculate area");
        int s= in.nextInt();

        int area = s*s;

        System.out.println("area of square is side squared i.e. "+area);
        in.close();
    }
}
