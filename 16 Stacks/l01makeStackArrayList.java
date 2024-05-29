import java.util.*;

public class l01makeStackArrayList {
    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // is Empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // Push
        public void push(int data) {
            list.add(data);
        }

        // Pop
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        // Peek
        public int peek() {
            int val = list.get(list.size() - 1);
            return val;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}