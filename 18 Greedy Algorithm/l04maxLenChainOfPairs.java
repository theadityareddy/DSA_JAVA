import java.util.Arrays;
import java.util.Comparator;

public class l04maxLenChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39,60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chain = 1;
        int chainEnd = pairs[0][1];

        for(int i=0; i<pairs.length; i++){
            if(chainEnd < pairs[i][0]){
                chain++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("the chain of max length is " + chain);
    }
}