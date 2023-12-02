package Solutions;

import java.util.HashMap;

public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> frequencyLimitMap = new HashMap<>();
        for (Character c : chars.toCharArray()){
            frequencyLimitMap.put(c, frequencyLimitMap.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words){
            HashMap<Character, Integer> frequencyLimitMapCopy = new HashMap<>(frequencyLimitMap);
            boolean canFormat = true;
            for (Character c : word.toCharArray()){
                if (frequencyLimitMapCopy.getOrDefault(c, 0) == 0){
                    canFormat = false;
                    break;
                }
                else{
                    frequencyLimitMapCopy.put(c, frequencyLimitMapCopy.get(c) - 1);
                }
            }
            if (canFormat){
                ans += word.length();
            }
        }
        return ans;
    }
}
