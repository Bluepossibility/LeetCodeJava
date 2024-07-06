package Solutions.HashMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution1608 {

    public int specialArray(int[] nums) {
        Map<Integer, Integer> freqMap = new TreeMap<>(Comparator.naturalOrder());
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1) ;
        }
        int cnt = 0; // count of seen numbers so far
        for (int value = 0; value <= nums.length; value++) {
            if (value == nums.length - cnt){
                // Because the keySet is sorted in natural order
                // nums.length - cnt is the count of numbers that is no less than value
                return value;
            }
            if (freqMap.containsKey(value)){
                cnt += freqMap.get(value);
            }
        }
        return -1;
    }
}
