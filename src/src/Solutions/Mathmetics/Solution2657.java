package Solutions.Mathmetics;

import java.util.HashSet;

public class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        assert A.length == B.length;
        int n = A.length;
        int[] ans = new int[n];
        HashSet<Integer> common = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        // Iterate over A and B at the same time
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                common.add(A[i]);
            }
            else {
                visitNumber(visited, common, A[i]);
                visitNumber(visited, common, B[i]);
            }
            ans[i] = common.size();
        }
        return ans;
    }

    private void visitNumber (HashSet<Integer> visited, HashSet<Integer> common, int num) {
        // Visit current num, if it's already visited, then add it to common
        if (!visited.contains(num)) {
            visited.add(num);
        }
        else {
            common.add(num);
        }
    }
}
