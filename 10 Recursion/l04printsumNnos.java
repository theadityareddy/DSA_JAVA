import java.util.Scanner;

public class l04printsumNnos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no :");
        int n = in.nextInt();
        System.out.println(Nnos(n));
        in.close();
    }

    public static int Nnos(int n) {
        if (n<=0)
            return -1;

        if (n==1)
            return 1;

        int sum = n + Nnos(n-1);
        return sum;
    }
}

// Time complexity is O(n)
// Space complexity is O(n)