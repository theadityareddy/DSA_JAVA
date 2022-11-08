public class l03factorial {
    public static void main(String[] args) {
        int n=5;
        System.out.println("Factorial is " + fact(n));
    }

    public static int fact(int n) {
        if (n==0){
            return 1;
        }
        int fact = n * fact(n-1);
        return fact;
    }
}

// Time complexity is O(n)
// Space complexity is O(n)