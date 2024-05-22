public class l02findSubsets {
    public static void findSubsets(String str, int i, String ans) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // recurssion
        // yes - add char to ans
        findSubsets(str, i + 1, ans + str.charAt(i));
        // no - dont add char to ans
        findSubsets(str, i + 1, ans);
    }

    public static void main(String[] args) {
        String str = "abc", ans = "";
        findSubsets(str, 0, ans);
    }
}
// Time Complexity = O(n*2^n)
// Space Complexity = O(n)