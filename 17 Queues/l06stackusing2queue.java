import java.util.*;

public class l06stackusing2queue {
    public static class Stack{
        static Queue <Integer> q1 = new LinkedList<>();
        static Queue <Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            int val=-1;
            if(!q1.isEmpty()){ //when elements are in q1
                while(!q1.isEmpty()){
                    val = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(val);
                }
            } else { // when elements are in q2
                while(!q2.isEmpty()){
                    val = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(val);
                }
            }
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            int val=-1;
            if(!q1.isEmpty()){ //when elements are in q1
                while(!q1.isEmpty()){
                    val = q1.remove();
                    q2.add(val);
                }
            } else { // when elements are in q2
                while(!q2.isEmpty()){
                    val = q2.remove();
                    q2.add(val);
                }
            }
            return val;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(5);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
