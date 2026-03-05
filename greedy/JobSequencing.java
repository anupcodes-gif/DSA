package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job implements Comparable<Job> {
    char id;
    int deadline, profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job other) {
        return other.profit - this.profit;
    }
}

public class JobSequencing {
    public void schedule(List<Job> jobs) {
        Collections.sort(jobs);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        char[] result = new char[maxDeadline];
        boolean[] slots = new boolean[maxDeadline];

        for (Job job : jobs) {
            for (int d = Math.min(maxDeadline, job.deadline) - 1; d >= 0; d--) {
                if (!slots[d]) {
                    slots[d] = true;
                    result[d] = job.id;
                    break;
                }
            }
        }

        System.out.print("Scheduled Jobs: ");
        for (char id : result) {
            if (id != 0) System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        System.out.println("Jobs: (a, 2, 100), (b, 1, 19), (c, 2, 27), (d, 1, 25), (e, 3, 15)");
        JobSequencing js = new JobSequencing();
        js.schedule(jobs);
    }
}
