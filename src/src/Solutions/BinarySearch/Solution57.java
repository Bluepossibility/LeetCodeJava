package Solutions.BinarySearch;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // edge case
        if (intervals.length == 0){
            return new int[][]{newInterval};
        }

        int n = intervals.length;
        int target = newInterval[0];
        int left = 0, right = n - 1;

        // Binary search to find the position to insert newInterval
        while (left <= right){
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        // Insert newInterval at the found position
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++){
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for(int i = left; i < n; i++){
            result.add(intervals[i]);
        }

        // Merge overlapping intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : result){
            // If res is empty or there is no overlap, add the interval to the result
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]){
                merged.add(interval);
            }
            else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }
}
