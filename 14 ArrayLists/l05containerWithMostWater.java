import java.util.*;

public class l05containerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1, 8, 6, 2, 5, 4, 8, 3, 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(mostWaterContainer(height));
    }

    public static int mostWaterContainer(ArrayList<Integer> height) {
        int lp = 0;
        int rp = height.size()-1;
        int maxArea = 0;
        
        while (lp<rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int area = ht * width;

            maxArea = Math.max(maxArea, area);

            if (height.get(lp)<height.get(rp)){
                lp++;
            } else {
                rp--;
            }
        }

        return maxArea;
    }
}
