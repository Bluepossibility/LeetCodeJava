package Solutions.Heap;

import java.util.PriorityQueue;

public class Solution1464 {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int num : nums){
            heap.add(num);
        }
        return (heap.poll() - 1) * (heap.poll() - 1);
    }
}
