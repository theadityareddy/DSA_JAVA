import java.util.Scanner;

public class q4DSA11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The trapped water is "+trapwater(height)); ;
        in.close();
    }

    public static int trapwater(int[] height) {
        int leftmax[]=new int[height.length];
        int rightmax[] = new int[height.length];

        //left max... from left to right
        leftmax[0]=height[0];
        for (int i=1;i<height.length;i++){
            leftmax[i]=Math.max(leftmax[i-1], height[i]);
        }

        //right max... from right tp left
        rightmax[height.length-1]=height[height.length-1];
        for (int i=height.length-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1], height[i]);
        }

        //loop 
        int trappedwater=0;
        for (int i=0; i<=height.length-1;i++){
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedwater += waterlevel - height[i];
        }

        return trappedwater;
    }
}
