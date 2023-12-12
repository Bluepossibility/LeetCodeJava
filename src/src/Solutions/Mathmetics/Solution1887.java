package Solutions.Mathmetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1887 {
    public int reductionOperations(int[] nums) {

        HashMap<Integer, Integer> num2FrequencyMap = new HashMap<>();
        for (int num : nums){
            num2FrequencyMap.put(num, num2FrequencyMap.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        List<Integer> sortedKeys = num2FrequencyMap.keySet().stream().sorted().toList();
        for (int idx = 1; idx < sortedKeys.size(); idx++){
            int currKey = sortedKeys.get(idx);
            ans += num2FrequencyMap.get(currKey) * idx;
        }
        return ans;
    }
}
