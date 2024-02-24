package Solutions.Tree;

public class Solution938 {

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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        else{
            int value2Add = root.val >= low && root.val <= high ? root.val : 0;
            return value2Add + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}
