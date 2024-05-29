import java.util.*;

public class l05reverseStack {
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int val = s.pop();
        reverseStack(s);
        pushAtBottom(s, val);
    }

    private static void pushAtBottom(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.push(val);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // 3, 2, 1
        reverseStack(s);
        // 1, 2, 3
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}