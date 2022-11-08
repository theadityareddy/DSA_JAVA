import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("enter no br 1-7 to select day of week, starting from mon");
        int n=in.nextInt();
        switch (n) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;    
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("enter valid data");
                break;
        }
        in.close();
    }
}
