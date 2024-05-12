import java.util.Scanner;

public class l10trappingrainwaterDSA22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int height[]={4,2,0,6,3,2,5};
        System.out.println("The area of trapped rain water is "+trappingrainwater(height));
        in.close();
    }

    public static int trappingrainwater(int height[]) {
        int n = height.length;

        int rightmax[]=new int[n];
        int leftmax[]=new int[n];

        // auxillary array : left max array
        leftmax[0]=height[0];
        for (int i = 1; i<n; i++){
            leftmax[i]=Math.max(leftmax[i-1], height[i]);
        }

        //auxilary array : right max array
        rightmax[n-1]=height[n-1];
        for (int i=n-2; i>=0; i--){
            rightmax[i]=Math.max(rightmax[i+1], height[i]);
        }

        //for loop to rainwater area
        int trappedarea = 0;
        for(int i=0;i<n;i++){
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedarea += waterlevel - height[i];
        }

        return trappedarea;
    }
}
