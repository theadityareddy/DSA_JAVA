import java.util.Scanner;

public class l4_prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to ckeck prime");
        int n= in.nextInt();
        int c=fact(n);
        if (c==1){
            System.out.println("entered no is prime");
        }
        else{
            System.out.println("entered no isnt prime");
        }
        in.close();
    }

    public static int fact(int n) {
        //2
        if (n==2){
            return 1;
        }

        // n>1
        // Every composite number has at least one prime factor less than or equal to square root of itself
        for(int i=3;i<Math.sqrt(n);i++)
        {
            System.out.println(i);
            if ((n%i)==0)
            {
                return 0;
            }
        }
        return 1;
    }
}
