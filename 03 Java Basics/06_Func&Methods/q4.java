import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to check if it's a palindrome :");
        int n = in.nextInt();

        System.out.println("sum of digits of entered no is "+ isPal(n));
        in.close();
    }

    public static int isPal(int n) {
        int sum=0;
        while(n!=0){
            int d=n%10;
            sum += d;
            n/=10;
        }
        return sum;
    }

}
