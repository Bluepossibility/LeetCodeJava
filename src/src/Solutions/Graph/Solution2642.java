package Solutions.Graph;

import java.util.Arrays;

public class Solution2642 {
    static class Graph {

        // 2D Array where minimumCost[i][j] is the known minimum cost from node i to node j
        // Keep updated as more edge is added into the graph
        private static int[][] minimumCost;

        // number of nodes
        private static int numOfNodes;

        public Graph(int n, int[][] edges) {

            numOfNodes = n;
            // * Initialize the minimumCost 2D array
            minimumCost = new int[n][n];
            for (int start = 0 ; start < n; start++){
                for (int end = 0; end < n; end++){
                    if (start == end){
                        // Always costs 0 to go to node itself
                        minimumCost[start][end] = 0;
                    }
                    else {
                        // Initialize the cost between each node pairs as infinite
                        minimumCost[start][end] = (int)1e9;
                    }
                }
            }
            // * Add the initial edges
            // Example edges: [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]]
            for (int[] edge : edges){
                minimumCost[edge[0]][edge[1]] = edge[2];
            }
            // * Update the minimumCost 2D array
            for (int nodeInBetween = 0; nodeInBetween < n; nodeInBetween++){
                for (int startNode = 0; startNode < n; startNode++){
                    for (int endNode = 0; endNode < n; endNode++){
                        minimumCost[startNode][endNode] =
                                Math.min(
                                        minimumCost[startNode][endNode],
                                        minimumCost[startNode][nodeInBetween] + minimumCost[nodeInBetween][endNode]);
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            int n = minimumCost.length;
            for (int startNode = 0; startNode < n; startNode++){
                for (int endNode = 0; endNode < n; endNode++){
                    minimumCost[startNode][endNode] =
                            Math.min(
                                    minimumCost[startNode][endNode],
                                    minimumCost[startNode][edge[0]] + edge[2] + minimumCost[edge[1]][endNode]);
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            if (minimumCost[node1][node2] == (int)1e9)
                return -1;
            return minimumCost[node1][node2];
        }
    }
}
