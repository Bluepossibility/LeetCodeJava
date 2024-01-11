package Solutions.Tree;

public class Solution1026 {


    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    class Solution {
        int maxDifference = 0;
        public int maxAncestorDiff(TreeNode root) {
            dfs(root, root.val, root.val);
            return maxDifference;
        }

        private void dfs(TreeNode root, int maxAncestorValue, int minAncestorValue){
            if (root != null){
                if (Math.abs(maxAncestorValue - root.val) > maxDifference){
                    maxDifference = Math.abs(maxAncestorValue - root.val);
                }
                if (Math.abs(minAncestorValue - root.val) > maxDifference){
                    maxDifference = Math.abs(minAncestorValue - root.val);
                }
                dfs(root.left, Math.max(maxAncestorValue, root.val), Math.min(minAncestorValue, root.val));
                dfs(root.right, Math.max(maxAncestorValue, root.val), Math.min(minAncestorValue, root.val));
            }
        }
    }
}
