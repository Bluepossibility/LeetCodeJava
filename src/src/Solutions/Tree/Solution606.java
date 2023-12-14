package Solutions.Tree;

public class Solution606 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;this.left = left;
            this.right = right;
        }
     }

    public String tree2str(TreeNode root) {
        if (root.left == null && root.right == null){
            return String.valueOf(root.val);
        }
        else if (root.left != null && root.right != null){
            return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
        }
        else if (root.left != null){
            return root.val + "(" + tree2str(root.left) + ")";
        }
        else {
            return root.val + "()(" + tree2str(root.right) + ")";
        }
    }
}
