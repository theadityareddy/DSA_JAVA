public class l05fibonacci {
    public static void main(String[] args) {
        int n=30; //ans should be 55
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n==0 || n==1){
            return n;
        }
        int fibonacci = fib(n-1) + fib(n-2);
        return fibonacci;
    }
}
// Time Complexity is O(n^2)
//Space Complexity is O(n)