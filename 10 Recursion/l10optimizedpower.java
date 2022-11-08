public class l10optimizedpower {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.print("Power is ");
        System.out.println(optimizedPower(x,n));
        int total = 10;
        total = 5+10;
        System.out.println(total);
    }

    private static int optimizedPower(int x, int n) {
        if (n==0){
            return 1;
        }

        //even
        int halfPower = optimizedPower(x, n/2);
        int halfPowerSquare = halfPower * halfPower;

        //if odd
        if(n%2 != 0){
            halfPowerSquare *= x;
        }

        return halfPowerSquare;
    }
}
//Time Complexity is O(log n) - Similar to binary search