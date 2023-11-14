package Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution1930 {

    public static int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet<>();
        for (Character c : s.toCharArray()){
            letters.add(c);
        }

        int ans = 0;
        for (Character letter : letters){
            int firstAppearanceIndex = -1;
            int lastAppearanceIndex = 0;

            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == letter){
                    // First appearance
                    if (firstAppearanceIndex == -1){
                        firstAppearanceIndex = i;
                    }
                    else{
                        lastAppearanceIndex = i;
                    }
                }
            }

            Set<Character> between = new HashSet<>();
            for (int i = firstAppearanceIndex + 1; i < lastAppearanceIndex; i++){
                between.add(s.charAt(i));
            }
            ans += between.size();
        }
        return ans;
    }
}
