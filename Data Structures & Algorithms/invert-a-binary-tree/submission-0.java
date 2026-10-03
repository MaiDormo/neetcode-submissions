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
    public TreeNode invertTree(TreeNode root) {
        return rec(null, root);
    }

    private TreeNode rec(TreeNode current, TreeNode old) {
        if (old == null) return null;

        current = new TreeNode(old.val);
        current.left = rec(current.left, old.right);
        current.right = rec(current.right, old.left);

        return current;
    }
}
