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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;           
        boolean[] res = new boolean[]{true};
        isBalanced(root,res);
        return res[0];
    }

    private int isBalanced(TreeNode node, boolean[] res){
        if (node == null) return 0;

        int left = isBalanced(node.left,res);
        int right = isBalanced(node.right,res);
        if (Math.abs(left-right) > 1) {
            res[0] = false;
        }
        return 1 + Math.max(left,right);
    }
}
