//Find the first occurence of key in an array using recurssion

import java.util.Scanner;

public class l07findKeyInArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = {8,3,6,9,5,10,2,5,3};
        int i=0;
        System.out.println("Enter the element who's first occurence you want to find");
        int key = in.nextInt();
        int ans = findKey(arr,key,i) + 1;
        System.out.println("The position of entered no in array is " + ((ans == 0) ? "not found" : ans));
        in.close();
    }

    private static int findKey(int[] arr, int key, int i) {
        if (arr.length == i){
            return -1;
        }
        if (arr[i]==key){
            return i;
        }

        return findKey(arr, key, i+1);
    }
}
// Time Complexity is O(n)
//Space Complexity is O(n)