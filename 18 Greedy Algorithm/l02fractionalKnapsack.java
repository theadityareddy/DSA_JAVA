import java.util.Arrays;
import java.util.Comparator;

public class l02fractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        // 0thCol = idx;
        // 1stCol = ratio;
        double ratio[][] = new double[val.length][2];
        for(int i=0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)val[i]/(double)weight[i];
        }

        // sorting in ascending order... but will traverse in rev
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int finalVal = 0;
        int capacity = W;

        // running loop on "ratio" in decending order
        for (int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if( capacity >= weight[idx]){
                // include full weight
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // include fractional weight
                finalVal += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("The final val is " + finalVal);
    }
}