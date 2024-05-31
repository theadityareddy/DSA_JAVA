import java.util.*;

public class l01activitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        int activities[][] = new int[end.length][3];

        // 0th col = idx
        // 1st col = start
        // 2nd col = end
        for (int i = 0; i < end.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function
        // sorting of activites -> based on its ending time/index
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // Create sol array
        int maxAct = 0;
        ArrayList<Integer> sol = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        sol.add(activities[0][0]); // idx
        int lastEnd = activities[0][2]; // end time
        for (int i = 0; i < end.length; i++) {
            // activity selection
            if (activities[i][1] >= lastEnd) { // startTime >= lastEndTime
                maxAct++;
                sol.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max activites are " + maxAct);
        for (int i = 0; i < sol.size(); i++) {
            System.out.print("A" + sol.get(i) + " ");
        }
        System.out.println();
    }
}