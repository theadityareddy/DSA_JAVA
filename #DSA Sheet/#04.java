import java.util.Scanner;

public class q1DSA4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[]={1,2,3,4,5,6,7,8,9,1};
        System.out.println("in array... freq : "+checkfreq(arr));
        in.close();
    }

    public static boolean checkfreq(int[] arr) {
        for (int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
