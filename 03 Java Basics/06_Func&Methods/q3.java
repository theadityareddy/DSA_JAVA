import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to check if it's a palindrome :");
        int n = in.nextInt();

        System.out.println("entered no is "+ (isPal(n)?"palindrome":"not palindrome"));
        in.close();
    }

    public static boolean isPal(int n) {
        int p=0;
        int c=n;
        while(n!=0){
            int d=n%10;
            p = p*10 + d;
            n/=10;
        }

        System.out.println("reversed no is "+p);

        if (p==c){
            return true;
        }
        else{
            return false;
        }
    }
}
