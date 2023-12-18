package Solutions.StringManipulation;

import java.util.HashMap;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charFrequencyMapS = new HashMap<>();
        HashMap<Character, Integer> charFrequencyMapT = new HashMap<>();

        // s --> t
        for (char c : s.toCharArray()){
            int frequency = charFrequencyMapS.getOrDefault(c, 0);
            charFrequencyMapS.put(c, frequency + 1);
        }
        for (char c : t.toCharArray()){
            int frequencyLeft = charFrequencyMapS.getOrDefault(c, 0);
            if (frequencyLeft == 0){
                return false;
            }
            else{
                charFrequencyMapS.put(c, frequencyLeft - 1);
            }
        }
        // t --> s
        for (char c : t.toCharArray()){
            int frequency = charFrequencyMapT.getOrDefault(c, 0);
            charFrequencyMapT.put(c, frequency + 1);
        }
        for (char c : s.toCharArray()){
            int frequencyLeft = charFrequencyMapT.getOrDefault(c, 0);
            if (frequencyLeft == 0){
                return false;
            }
            else{
                charFrequencyMapT.put(c, frequencyLeft - 1);
            }
        }
        return true;
    }
}
