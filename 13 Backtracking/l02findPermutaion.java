public class l02findPermutaion {
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, " ");
    }

    public static void findPermutations(String str, String ans) {
        //base case
        if (str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recurssion
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1, str.length());
            findPermutations(newStr, ans+ch);
        }
    }
}
// Time Complexity  = O(n*n!)
// Space Complexity = O(n)