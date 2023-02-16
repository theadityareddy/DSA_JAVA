import java.util.*;

public class l05indianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int value = 590;
        int countOfCoins = 0;
        ArrayList<Integer> listOfCoins = new ArrayList<>();

        for(int i=0; i<coins.length; i++){
            if(coins[i]<=value){
                while(coins[i]<=value){
                    countOfCoins++;
                    value -= coins[i];
                    listOfCoins.add(coins[i]);
                }
            }
        }

        System.out.println("min no of coins used are " + countOfCoins);
        for(int i=0; i<listOfCoins.size(); i++){
            System.out.print("Rs." + listOfCoins.get(i) + ", ");
        }
        System.out.println();
    }
}