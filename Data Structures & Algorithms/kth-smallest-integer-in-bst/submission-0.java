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
    private int value = 0;
    private int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return value;
    }

    private void dfs(TreeNode node, int k) {
        if(node == null) return;
        
        dfs(node.left, k);
        if (counter >= k) return;

        counter++;
        if(counter == k) {
            value = node.val;
            return;
        }

        dfs(node.right, k);
    }
}
