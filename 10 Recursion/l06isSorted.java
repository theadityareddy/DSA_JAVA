//Check if an array is sorted

public class l06isSorted {
    public static void main(String[] args) {
        int arr[]={1,2,7,4,5,6,7,8,9};
        boolean ans = isSorted(arr,0);
        System.out.println(ans);
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i==arr.length-1){
            return true;
        }
        if (arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
}
// Time Complexity is O(n)
//Space Complexity is O(n)