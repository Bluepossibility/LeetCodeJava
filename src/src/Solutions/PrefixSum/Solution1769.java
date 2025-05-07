package Solutions.PrefixSum;

public class Solution1769 {

    public int[] minOperations(String boxes) {
        int[] prefixSum = new int[boxes.length()];
        int s = 0; // sum of balls
        int headOpNmbr = 0; // operations needed for moving all the balls to the head (first) box
        for (int i = 0; i < boxes.length(); i++) {
            int boxValue = Integer.parseInt(String.valueOf(boxes.charAt(i)));
            s += boxValue;
            prefixSum[i] = s; // prefix sum
            headOpNmbr += i * boxValue;
        }

        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            if (i == 0) {
                ans[i] = headOpNmbr;
            }
            else {
                int ballsLeft = prefixSum[i - 1];
                int ballsNotLeft = s - ballsLeft;
                // as we move the pivot to right
                // all balls to the left are further by 1
                // all balls in the current box and to the right are closer by 1
                ans[i] = ans[i-1] - ballsNotLeft + ballsLeft;
            }
        }
        return ans;
    }
}
