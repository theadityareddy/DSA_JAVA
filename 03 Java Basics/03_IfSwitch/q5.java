import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter year to check if its a leap year or not");
        int yr= in.nextInt();
        if (((yr%4==0)&&(yr%100!=00)) || yr%400==0) {
            System.out.println(yr + " is a leap yr");
        }
        else{
            System.out.println(yr + " isn't a leap yr");
        }
        in.close();
    }
}
