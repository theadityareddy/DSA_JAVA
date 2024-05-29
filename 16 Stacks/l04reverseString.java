import java.util.*;

public class l04reverseString {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder finalStr = new StringBuilder("");
        while (!s.isEmpty()) {
            finalStr.append(s.pop());
        }
        return finalStr.toString();
    }

    public static void main(String[] args) {
        String str = "adi";
        System.out.println(reverseString(str));
    }
}