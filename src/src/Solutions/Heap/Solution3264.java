package Solutions.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Priority Queue that accepts element such as [value, index]
        // where value takes precedence over indices
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            // try comparing value
            if (!a[0].equals(b[0])) {
                return Integer.compare(a[0], b[0]);
            }
            // compare indices if values are the same
            return Integer.compare(a[1], b[1]);
        });
        // Add all numbers to Priority Queue
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(new Integer[] {nums[i], i});
        }
        // Overwrite values then add back to Priority Queue, for k times
        while (k > 0) {
            Integer[] element = priorityQueue.poll();
            if (element != null) {
                int value = element[0];
                int index = element[1];
                nums[index] = value * multiplier;
                priorityQueue.offer(new Integer[] {value * multiplier, index});
            }
            k--;
        }

        return nums;
    }

}
