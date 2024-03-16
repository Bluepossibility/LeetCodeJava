package Solutions.WindowSliding;

public class Solution930 {

    private int slidingWindowAtMostN(int[] nums, int n){
        int start = 0;
        int currSum = 0;
        int slidingWindowCnt = 0;
        for (int end = 0; end < nums.length; end++) {
            currSum += nums[end];
            while(start <= end && currSum > n){
                currSum -= nums[start];
                start += 1;
            }
            slidingWindowCnt += end - start + 1;
        }

        return slidingWindowCnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMostN(nums, goal) - slidingWindowAtMostN(nums, goal - 1);
    }
}
