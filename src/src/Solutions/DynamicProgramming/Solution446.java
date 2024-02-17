package Solutions.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class Solution446 {

    // * memo's key is the difference of an arithmetic array
    // * memo's value is the number of possible slices
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    private static HashMap<Integer, Integer> frequency = new HashMap<>();
    
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int maxNum = nums[nums.length - 1];                         
        // ! Calculate possible slices that have equal elements, i.e. difference == 0
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }
        for (int num : frequency.keySet()){
            ans += calPossibleSubsequences(frequency.get(num), 0);
        }
        // ! Calculate possible slices that don't have equal elements, i.e. difference != 0
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i < j && nums[i] != nums[j]){
                    int diff = nums[j] - nums[i];
                    if (memo.get(diff) == null){
                        int lengthOfArithmeticArray = 2;
                        int currNum = nums[j] + diff;
                        while(currNum < maxNum){
                            if (frequency.get(currNum) != null){
                                lengthOfArithmeticArray += 1;
                            }
                            currNum += diff;
                        }
                        ans += calPossibleSubsequences(lengthOfArithmeticArray, diff);
                    }
                }
            }
        }
        return ans;
    }
    
    private int calPossibleSubsequences(int lengthOfArithmeticArray, int diff){
        // * return number of possible subsequences given an arithmetic array
        int ans = 0;
        if (diff == 0){
            for (int i = 3; i <= lengthOfArithmeticArray; i++) {
                ans += combinations(lengthOfArithmeticArray, lengthOfArithmeticArray - i);
            }
        }
        else{
            for (int i = 3; i < lengthOfArithmeticArray; i++) {
                ans += lengthOfArithmeticArray - i + 1;
            }
        }
        return ans;
    }
    
    private int combinations(int n, int k){
        // * return Cnk
        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= n - i;
        }
        ans /= factorial(k);
        return ans;
    }
    
    private int factorial(int num){
        if (num == 0){
            return 1;
        }
        int ans = 1;
        while (num > 1){
            ans *= num;
            num -= 1;
        }
        return ans;
    }
}
