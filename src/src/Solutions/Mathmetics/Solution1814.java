package Solutions.Mathmetics;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1814 {
    public static int countNicePairs(int[] nums) {
        int[] transformedNums = Arrays.stream(nums).map(Solution1814::reversedNumMinusNum).toArray();
        int ans = 0;
        HashMap<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int num : transformedNums){
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int numKey : numFrequencyMap.keySet()){
            ans += calculateCombinations(numFrequencyMap.get(numKey));
        }
        return ans;
    }

    public static int calculateCombinations(int n) {
        assert n > 0;
        if (n == 1){
            return 0;
        }
        else {
            return n * (n - 1) / 2;
        }
    }

    private static int reversedNumMinusNum(int num){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num);
        stringBuilder.reverse();
        int reversedNum = Integer.parseInt(stringBuilder.toString());
        return reversedNum - num;
    }
}
