import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ch, n, e=0, o=0;
        do
        {
            System.out.println("enter no");
            n=in.nextInt();
            if ((n%2)==0){
                e+=n;
            }
            else{
                o+=n;
            }
            System.out.println("\nenter \n1 to conti \n0 to stop");
            ch=in.nextInt();
        }while(ch!=0);
        System.out.println("sum of even nos is "+e);
        System.out.println("sum of odd nos is "+o);
        in.close();
    }
}
