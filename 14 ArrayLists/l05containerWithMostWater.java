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
        int rp = height.size() - 1;
        int maxWaterArea = 0;

        while (lp < rp) {
            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int area = ht * width;

            maxWaterArea = Math.max(maxWaterArea, area);

            // update pointer
            // we update smaller one because :
            // case 1 - if larger one is updated to smaller one then loss hoga as maxWater
            // kam hoga.
            // case 2 - if larger one is updated to larger one then height of water same
            // hoga but width kam hoga.
            // case 3 - if larger one is updated to same height wala then also loss as width
            // kam hoga.
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWaterArea;
    }
}
