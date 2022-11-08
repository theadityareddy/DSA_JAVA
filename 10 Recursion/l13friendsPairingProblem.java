//Friend's Pairing Problem
//@GoldmmanSachs
public class l13friendsPairingProblem {
    public static void main(String[] args) {
        int n=5;
        System.out.println(friendsParing(n));
    }

    private static int friendsParing(int n) {
        //base (1 person can be alone, 2 ppl can either be single or be a couple)
        if ((n==1) || (n==2)){
            return n;
        }

        //main code : TotalWays = single ways + couple ways (no of ppl whom you can be with x no of ppl remaining)
        int totalWays = friendsParing(n-1) + ((n-1)*friendsParing(n-2));
        return totalWays;
    }
}