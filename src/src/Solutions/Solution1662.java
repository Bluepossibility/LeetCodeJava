package Solutions;

import java.util.Arrays;

public class Solution1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (String subWord1 : word1){
            stringBuilder1.append(subWord1);
        }
        String string1 = stringBuilder1.toString();

        StringBuilder stringBuilder2 = new StringBuilder();
        for (String subWord2:word2) {
            stringBuilder2.append(subWord2);
        }
        String string2 = stringBuilder2.toString();
        return string1.equals(string2);
    }
}
