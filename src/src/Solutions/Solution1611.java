package Solutions;

public class Solution1611 {
    public int minimumOneBitOperations(int n) {
        int ans  = n;
        ans ^= ans >> 16;
        ans ^= ans >> 8;
        ans ^= ans >> 4;
        ans ^= ans >> 2;
        ans ^= ans >> 1;
        return ans;
    }
}
