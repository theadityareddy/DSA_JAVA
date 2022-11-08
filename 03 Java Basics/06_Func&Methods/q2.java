import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to check if its even :");
        int n = in.nextInt();

        System.out.println("entered no is "+ (isEven(n)?"even":"not even"));
        in.close();
    }

    public static boolean isEven(int n) {
        if (n%2==0){
            return true;
        }
        else{
            return false;
        }
    }
}
