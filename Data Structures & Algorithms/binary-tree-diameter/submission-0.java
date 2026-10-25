/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode root) {
        if(root == null) return -1;

        int leftDepth = 1+dfs(root.left);
        int rightDepth = 1+dfs(root.right);
        int nodeDiameter = leftDepth + rightDepth;

        if(nodeDiameter > maxDiameter) {
            maxDiameter = nodeDiameter;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
