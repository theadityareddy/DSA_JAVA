import java.util.*;

public class l06jobSeqProblem {
    static class Jobs {
        int id;
        int deadline;
        int profit;

        public Jobs(int id, int d, int p) {
            this.id = id;
            this.deadline = d;
            this.profit = p;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } }; // ans = c, a or 2, 0

        ArrayList<Jobs> job = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            job.add(new Jobs(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(job, (job1, job2) -> job2.profit - job1.profit);
        // sorts in decending order

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < job.size(); i++) {
            Jobs curr = job.get(i);
            if (curr.deadline > time) {
                time++;
                seq.add(curr.id);
            }
        }

        System.out.println("max no of job done is " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
    }
}