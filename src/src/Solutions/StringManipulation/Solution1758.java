package Solutions.StringManipulation;

public class Solution1758 {
    public int minOperations(String s) {
        int ans = 0;
        int idealNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!String.valueOf(s.charAt(i)).equals(String.valueOf(idealNum))){
                ans += 1;
            }
            idealNum = 1 - idealNum;
        }
        return Math.min(s.length() - ans, ans);
    }
}
