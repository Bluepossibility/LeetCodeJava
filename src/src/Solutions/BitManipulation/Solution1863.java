package Solutions.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1863 {
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> allSubsets = allSubsets(nums);
        int ans = 0;
        for (List<Integer> subset : allSubsets){
            int subsetXOR = 0;
            for (Integer num : subset){
                subsetXOR ^= num;
            }
            ans += subsetXOR;
        }
        return ans;
    }

    private static List<List<Integer>> allSubsets(int[] nums){
        if (nums.length == 0){
            return new ArrayList<>();
        }
        else if (nums.length == 1){
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();
            subset.addLast(nums[0]);
            subsets.addLast(subset);
            return subsets;
        }
        else {
            int[] subArray = Arrays.copyOfRange(nums, 0, nums.length - 1);
            List<List<Integer>> prevSubsets = allSubsets(subArray);

            int currNum = nums[nums.length - 1];
            // * add the curr num to all previous subsets to form new subsets
            List<List<Integer>> newSubsets = new ArrayList<>(prevSubsets);
            for (List<Integer> prevSubset : prevSubsets){
                List<Integer> newSubset = new ArrayList<>(prevSubset);
                newSubset.addLast(currNum);
                newSubsets.addLast(newSubset);
            }
            // * add subset of the curr num itself
            List<Integer> selfSubset = new ArrayList<>();
            selfSubset.add(currNum);
            newSubsets.addLast(selfSubset);

            return newSubsets;
        }
    }
}
