import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double temp=103.5;
        if (temp > 100){
            System.out.println("you have fever");
        }
        else{
            System.out.println("you dont have fever");
        }
        in.close();
    }
}
