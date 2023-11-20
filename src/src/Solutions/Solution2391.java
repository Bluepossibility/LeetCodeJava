package Solutions;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        // * Array to store the prefix sum in travel
        int[] prefixSum = new int[travel.length + 1];
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++){
            prefixSum[i + 1] = prefixSum[i] + travel[i];
        }

        // Map to store garbage type to the last house index.
        HashMap<Character, Integer> garbageLastPos = new HashMap<>();

        // Map to store the total count of each type of garbage in all houses.
        HashMap<Character, Integer> garbageCount = new HashMap<>();
        for (int i = 0; i < garbage.length; i++){
            for (char c : garbage[i].toCharArray()){
                garbageLastPos.put(c, i);
                garbageCount.put(c, garbageCount.getOrDefault(c, 0) + 1);
            }
        }

        String garbageType = "MPG";
        int ans = 0;
        for (char c : garbageType.toCharArray()){
            // add only if there is at least one unit of this garbage.
            if (garbageCount.containsKey(c)){
                ans += prefixSum[garbageLastPos.get(c)] + garbageCount.get(c);
            }
        }
        return ans;
    }
}
