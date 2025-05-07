package Solutions.BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answerList = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(answerList, new ArrayList<Integer>(), candidates, target, 0);
        return answerList;
    }

    private void backtrack(List<List<Integer>> answerList, ArrayList<Integer> integers, int[] candidates, int target, int i) {
        
    }

}
