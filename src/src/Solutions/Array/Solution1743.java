package Solutions.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1743 {

    // Restore the Array From Adjacent Pairs

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static int[] restoreArray(int[][] adjacentPairs){

        // Create graph
        for (int[] edge : adjacentPairs){
            int firstNode = edge[0];
            int secondNode = edge[1];
            if (!graph.containsKey(firstNode)){
                graph.put(firstNode, new ArrayList<>());
            }
            if (!graph.containsKey(secondNode)){
                graph.put(secondNode, new ArrayList<>());
            }
            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        // Find root
        int root = 0;
        for (int num : graph.keySet()){
            if (graph.get(num).size() == 1 ){
                root = num;
            }
        }

        // Initialize the answer Integer Array
        int[] ans = new int[graph.size()];
        // DFS to populate the answer Array
        dfs(root, Integer.MAX_VALUE, ans, 0);
        return ans;
    }

    private static void dfs(int node, int prev, int[] ans, int stepIdx) {
        ans[stepIdx] = node;
        for (int neighbor: graph.get(node)){
            if (neighbor != prev){
                dfs(neighbor, node, ans, stepIdx+1);
            }
        }
    }
}
