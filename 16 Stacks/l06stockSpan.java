import java.util.*;

public class l06stockSpan {
    public static void findStockSpan(int[] stock, int[] span) {
        Stack<Integer> s = new Stack<>();
        // 1st element of span will be always 1
        span[0] = 1;
        s.push(0);
        // find span for all stock
        for (int i = 1; i < span.length; i++) {
            while (!s.isEmpty() && stock[i] > stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            }
            // span = the index - prevHigh
            span[i] = i - s.peek();
            // add curr index to stack
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stock.length];

        findStockSpan(stock, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }
}