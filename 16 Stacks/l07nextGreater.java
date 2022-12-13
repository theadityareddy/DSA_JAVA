import java.util.*;
// This Q is very imp as it has the same logic for all of the below Qs
// next greater right
// next greater left
// next smallest right
// next smallert left
public class l07nextGreater {
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        int arr[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int [arr.length];

        for (int i=arr.length-1 ; i>=0 ; i--){
            // 1. While loop to remove smaller elements and get nextGreater
            while (!s.empty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            // 2. Fill nextGreater array
            if (s.isEmpty()){
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // 3. Push curr idx
            s.push(i);
        }

        for (int i=0; i<nextGreater.length;i++){
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
// Time Complexity is O(n)
// this is because the elements only once go in stack and come out resulting in 2n Time Complexity, 
// and outer for loop has n, so in total 3n Time Complexity