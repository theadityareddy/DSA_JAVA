public class l09powerWithRecurssion {
    public static void main(String[] args) {
        System.out.println(power(2,10)); 
    }

    private static int power(int x, int n) {
        if (n==0){
            return 1;
        }
        // x = x * power(x, n-1); //X^n => X x X^(n-1)
        // return x;

        return x * power(x, n-1);
    }
}
