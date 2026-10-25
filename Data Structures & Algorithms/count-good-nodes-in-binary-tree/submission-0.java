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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs(root.val, root);
    }

    private int dfs(int currentMax, TreeNode node) {
        if(node == null) return 0;

        int countNode = 0;
        if(node.val >= currentMax) {
            currentMax = node.val;
            countNode = 1;
        }

        return countNode+dfs(currentMax, node.left)+dfs(currentMax, node.right);
    }
}
