package Solutions.DynamicProgramming;

public class Solution1155 {

    private static final int modulo = 1000000007;

    private static int facesOfDice;
    private static Integer[][] memo;

    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n][target];
        facesOfDice = k;
        return helper(n, target);
    }

    private int helper(int n, int target){
        if (target < 1){
            return 0;
        }
        else if (n == 1){
            return facesOfDice >= target ? 1 : 0;
        }
        else if (memo[n - 1][target - 1] != null){
                return memo[n - 1][target - 1];
        }
        else{
            int ways = 0;
            for(int i = 1; i <= facesOfDice; i++){
                ways += helper(n - 1, target - i) % modulo;
            }
            memo[n - 1][target - 1] = ways;
            return ways;
        }
    }
}
