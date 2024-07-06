package Solutions.Mathmetics;

public class Solution2582 {
    public int passThePillow(int n, int time) {
        // * every 2 * (n - 1) steps, the pillow is back to the initial state
        int lastRoundSteps = time % (2*(n - 1));
        // ! only consider the last round
        // * forward
        if (lastRoundSteps <= n - 1){
            return lastRoundSteps + 1;
        }
        // * backward
        else{
            int backwardSteps = lastRoundSteps - (n - 1);
            return n - backwardSteps;
        }
    }
}
