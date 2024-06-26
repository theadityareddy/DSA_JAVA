import java.util.*;

public class l13largestSubarray0Sum {
    public static void main(String args[]){
        int arr[] = {15,-2,2,-8,1,7,10,23};

        //HashMap : sum, i
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum =0;
        int maxLen =0;

        for(int j =0; j<arr.length; j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                // means the sum is repeating so value of max Subarray can increase
                // max is between after the last similar sum of subarray to the elment now
                maxLen =  Math.max(maxLen,j-map.get(sum));
            }else{
                map.put(sum,j);
            }
        }

        System.out.println("Max subarray with sum  0 is " + maxLen);
    }
}