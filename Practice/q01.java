public class q01 {
    public int divide(int dividend, int divisor) {
        // Check if the result should be negative
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Convert dividend and divisor to their absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        // Subtract the divisor from the dividend until the dividend is smaller than the divisor
        while (absDividend >= absDivisor) {
            absDividend -= absDivisor;
            quotient++;
        }

        // Apply the sign to the quotient
        quotient = sign == -1 ? -quotient : quotient;

        // Handle overflow
        if (quotient < Integer.MIN_VALUE || quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) quotient;
    }

    public static void main(String[] args) {
        q01 solution = new q01();
        System.out.println(solution.divide(10, 3));  // Output: 3
        System.out.println(solution.divide(7, -3)); // Output: -2
    }
}
