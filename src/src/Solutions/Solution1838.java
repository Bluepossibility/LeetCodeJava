package Solutions;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1838 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long curr = 0;

        for (int right = 0; right < nums.length; right++){
            int target = nums[right];
            curr += target;

            while ((right - left + 1) * target - curr > k){
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
