package Solutions;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1838 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long windowSum = 0;

        for (int right = 0; right < nums.length; right++){
            int target = nums[right];
            windowSum += target;

            if ((long)(right - left + 1) * target - windowSum > k){
                windowSum -= nums[left];
                left ++;
            }
        }

        return nums.length - left + 1;
    }
}
