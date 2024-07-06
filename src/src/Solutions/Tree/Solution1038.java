package Solutions.Tree;

public class Solution1038 {

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

    private int s = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null){
            return null;
        }
        // * traverse all the nodes under the right child
        root.right = bstToGst(root.right);

        // * after checking all the nodes to the right, update sum and root value
        int temp = root.val;
        root.val += s;
        s += temp;

        // * finally traverse all the nodes under the left child
        root.left = bstToGst(root.left);

        return root;
    }
}
