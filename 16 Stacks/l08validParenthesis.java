import java.util.*;

public class l08validParenthesis {
    public static boolean validParenthesis(String str){
        Stack <Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
                s.push(ch);
            } else {
                if(s.isEmpty()){ // checks if string has only closing bracket : "])]"
                    return false;
                }
                if ((ch == ')' && s.peek() == '(') ||
                    (ch == '}' && s.peek() == '{') ||
                    (ch == ']' && s.peek() == '[')) {
                        s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "(){[(){}]}";
        
        System.out.println(validParenthesis(str));
    }
}
// Time Complexity is O(n)
// this is because the elements only once go in stack and come out resulting in 2n Time Complexity, 
// and outer for loop has n, so in total 3n Time Complexity