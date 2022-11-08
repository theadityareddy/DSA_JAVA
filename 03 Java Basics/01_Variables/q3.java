import java.util.Scanner;

public class q3 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.println("enter price of pencil");
        float pencil= in.nextFloat();
        System.out.println("enter price of pen");
        float pen= in.nextFloat();
        System.out.println("enter price of eraser");
        float eraser= in.nextFloat();

        double total = ((pencil + pen + eraser) * (100+18))/100;
        System.out.println("Your total is "+total);
        in.close();
    }
}
