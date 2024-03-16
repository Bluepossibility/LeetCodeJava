package Solutions.PrefixSum;

import java.util.HashMap;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sum2FirstIndexMap = new HashMap<>();
        sum2FirstIndexMap.put(0, 0);
        int ans = 0;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i] == 1 ? 1 : -1;
            if (sum2FirstIndexMap.get(currSum) == null){
                sum2FirstIndexMap.put(currSum, i + 1);
            }
            else {
                int sumFirstIndex = sum2FirstIndexMap.get(currSum);
                int sumMaxLength = i - sumFirstIndex + 1;
                ans = Math.max(ans, sumMaxLength);
            }
        }
        return ans;
    }
}
