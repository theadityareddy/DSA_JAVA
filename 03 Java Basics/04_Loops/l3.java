import java.util.Scanner;

public class l3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Start entering no.");
        while(true){
            n=in.nextInt();
            if (n%10==0)
                break;
            System.out.println("you entered "+n);
        }
        in.close();
    }
}
