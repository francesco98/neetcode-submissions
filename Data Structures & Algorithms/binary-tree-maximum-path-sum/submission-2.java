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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        this.maxSum = Integer.MIN_VALUE;
        max(root);
        return this.maxSum;
    }

    private int max(TreeNode node) {
        if(node == null) return 0;

        int sumLeft = Math.max(0, max(node.left));
        int sumRight = Math.max(0, max(node.right));

        this.maxSum = Math.max(this.maxSum, node.val+sumLeft+sumRight);
        return Math.max(node.val+sumLeft, node.val+sumRight);       
    }
}
