//Binary Strings Problem
//@PayTm
//print binary strings of size N without consecutive '1'
public class l14binaryStringsProb {
    public static void main(String[] args) {
        int n=3;
        binaryStrings(n, 0, "");
    }

    private static void binaryStrings(int n, int last, String str) {
        if (n==0){
            System.out.println(str);
            return;
        }
        // for 0
        binaryStrings(n-1, 0, str + "0");
        //for 1 ... if previous is 0 then only we'll print 1 so that '1' doesn't repeat
        if (last == 0){
            binaryStrings(n-1, 1, str + "1");
        }
    }
}
