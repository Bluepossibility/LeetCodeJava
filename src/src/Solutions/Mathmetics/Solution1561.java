package Solutions.Mathmetics;

import java.util.Arrays;

public class Solution1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for (int i = piles.length/3; i < piles.length; i += 2){
            ans += piles[i];
        }
        return ans;
    }
}
