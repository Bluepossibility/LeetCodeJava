package Solutions;

import java.util.Arrays;

public class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int minimizedMax = 0;
        for(int i = 0; i < nums.length/2; i++){
            minimizedMax = Math.max(nums[i] + nums[nums.length - 1 - i], minimizedMax);
        }
        return minimizedMax;
    }
}
