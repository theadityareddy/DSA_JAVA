public class l01findSubsets {
    public static void main(String[] args) {
        String str = "abc",ans="";
        findSubsets(str, 0,ans);
    }

    public static void findSubsets(String str, int i, String ans) {
        //base case
        if (i==str.length()){
            System.out.println(ans);
            return;
        }
        //recurssion
        //yes
        findSubsets(str, i+1, ans+str.charAt(i));
        //no 
        findSubsets(str, i+1, ans);
    }
}
// Time Complexity  = O(n*2^n)
// Space Complexity = O(n)