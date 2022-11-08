import java.util.Scanner;

public class l4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter no to check if its prime");
        int n=in.nextInt();
        int x=0;
        
        for(int i=2;i<(n/2);i++){
            if (n%i==0){
                x++;
                break;
            }
        }

        if(x>0){
            System.out.println(n + " is a not a prime no");
        }
        else{
            System.out.println(n+" is a prime no");
        }
        in.close();
    }
}
