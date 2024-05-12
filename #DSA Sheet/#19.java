import java.util.Scanner;

public class l11buysellstocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int price[]={7,1,5,3,6,4};
        System.out.println("The maximum profit is "+ buysellstockes(price));
        in.close();
    }

    public static int buysellstockes(int[] price) {
        int minbuy=Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i<price.length; i++){
            if (minbuy<price[i]){
                int profit = price[i] - minbuy; // todays profit
                maxprofit = Math.max(maxprofit, profit); // check if todays profit is the max profit
            }
            else{
                minbuy=price[i]; // if todays price is less, then change min buying price to todays price
            }
        }
        return maxprofit;
    }
}
