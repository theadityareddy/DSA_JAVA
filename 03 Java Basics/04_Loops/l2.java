import java.util.Scanner;

public class l2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1=0,d;
        System.out.println("enter no to reverse");
        int n = in.nextInt();
        for(int i=n;i>0;i/=10){
            d = i%10;
            n1= (n1*10) + d;
        }
        System.out.println("reversed no is "+n1);
        in.close();
    }
}
