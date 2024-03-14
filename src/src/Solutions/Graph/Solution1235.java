package Solutions.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1235 {
    int [] memo = new int[50001];

    private int  findNextJobBinarySearch(int[] startTime, int lastEndingTime){
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        while (start <= end){
            int mid = (start + end)/2;
            if (startTime[mid] >= lastEndingTime){
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position){
        if (position == n){
            return 0;
        }

        if (memo[position] != -1){
            return memo[position];
        }
        // int currJobStartTime = jobs.get(position).get(0);
        int currJobEndTime = jobs.get(position).get(1);
        int currJobProfit = jobs.get(position).get(2);
        int nextIndex = findNextJobBinarySearch(startTime, currJobEndTime);
        int profitTakeCurr = currJobProfit + findMaxProfit(jobs, startTime, n, nextIndex);
        int profitSkipCurr = findMaxProfit(jobs, startTime, n, position + 1);
        int maxProfit = Math.max(profitTakeCurr, profitSkipCurr);
        memo[position] = maxProfit;
        return maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        Arrays.fill(memo, -1);

        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(job -> job.get(0)));

        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }


        return findMaxProfit(jobs, startTime, length, 0);
    }
}
