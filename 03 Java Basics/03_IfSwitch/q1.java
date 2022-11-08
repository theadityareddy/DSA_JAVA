import java.util.Scanner;

public class q1 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no");
        int n = in.nextInt();
        if (n>=0){
            System.out.println("entered no is positive");
        }
        else{
            System.out.println("entered no is negetive");
        }
        in.close();
    }
    
}