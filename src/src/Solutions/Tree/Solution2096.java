package Solutions.Tree;

public class Solution2096 {

    public static class TreeNode {
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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        String root2StartPath = findPath(root, startValue, "");
        String root2EndPath = findPath(root, destValue, "");
        System.out.println(root2StartPath);
        System.out.println(root2EndPath);
        int shorterPathLength = Math.min(root2StartPath.length(), root2EndPath.length());
        int commonPathLength = 0;
        for (int i = 0; i < shorterPathLength; i++) {
            if (root2StartPath.charAt(i) == root2EndPath.charAt(i)){
                commonPathLength += 1;
            }
            else{
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        // from start to LCA(Lowest Common Ancestor)
        for (int i = 0; i < root2StartPath.length() - commonPathLength; i++) {
            sb.append("U");
        }
        // from LCA to dest
        sb.append(root2EndPath.substring(commonPathLength));
        return sb.toString();
    }

    private String findPath(TreeNode node, int targetValue, String path){
        if (node == null){
            return null;
        }
        else if (node.val == targetValue){
            return path;
        }
        else {
            String leftNodePath = findPath(node.left, targetValue, path);
            if (leftNodePath != null){
                return "L" + leftNodePath;
            }
            String rightNodePath = findPath(node.right, targetValue, path);
            if (rightNodePath != null){
                return "R"  + rightNodePath;
            }
            return null;
        }
    }
}
