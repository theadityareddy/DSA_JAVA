import java.util.*;

public class l10maxRectAreaInHistogram {
    public static int maxArea (int arr[]){
        int area = 0;
        int flm[] = new int[arr.length]; // first left min
        int frm[] = new int[arr.length]; // first right min
        Stack<Integer> s = new Stack<>();

        // first right min
        for (int i=arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                frm[i] = arr.length;
            } else {
                frm[i] = s.peek();
            }
            s.push(i);
        }
        // first left min
        for (int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                flm[i] = -1;
            } else {
                flm[i] = s.peek();
            }
            s.push(i);
        }
        // calculate area;
        for (int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = frm[i] - flm[i] -1;
            area = Math.max(area, (height*width));
        }
        return area;
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        System.out.println(maxArea(arr));
    }
}
