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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(0, preorder, inorderMap, 0, inorder.length);        
    }

    private TreeNode build(int rootIndex, int[] preorder, Map<Integer, Integer> inorderMap, int l, int r) {
        if(l >= r) return null;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int inorderIndex = inorderMap.get(root.val);

        int leftSize = inorderIndex - l;
        int rightSize = r - inorderIndex - 1;
        
        root.left = build(rootIndex+1, preorder, inorderMap, l, inorderIndex);
        root.right = build(rootIndex+leftSize+1, preorder, inorderMap, inorderIndex+1, r);

        return root;
    }

    
}
