//Tiling Problem
//@amazon
public class l11tilingProbAmazon {
    public static void main(String[] args) {
        int n=5;
        System.out.println(tiling(n));
    }

    private static int tiling(int n) {
        //base
        if ((n==0) || (n==1)){
            return 1;
        }

        //main code : TotalWays = vertical ways + horizontal ways
        int totalWays = tiling(n-1) + tiling(n-2);
        return totalWays;
    }
}
