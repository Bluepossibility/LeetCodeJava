package Solutions.Mathmetics;

public class Solution1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int[] ans = new int[nums.length];
        // Iterate over the nums indexes to populate answer
        for (int i = 0; i < nums.length; i++){
            // if i equals to 0, populate the corresponding answer based on the summation of the distances
            if (i == 0){
                int sumDist = 0;
                for (int j = 1; j < nums.length; j++){
                    // ans[j] - ans[i] >= 0 as nums is sorted as non-decreasing
                    sumDist += nums[j] - nums[0];
                }
                ans[0] = sumDist;
            }
            // Otherwise, populate the answer ans[i] based on the ans[i-1]
            else {
                // For the current number
                int numsOnLeft = i - 1;
                int numsOnRight = nums.length - numsOnLeft - 2;
                int distWithPrev = nums[i] - nums[i-1];
                ans[i] = ans[i-1] + distWithPrev * (numsOnLeft - numsOnRight);
            }
        }
        return ans;
    }
}
