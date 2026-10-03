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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int[] res = rec(root);
        return res[0];        
    }

    private int[] rec(TreeNode node) {
        

        int[] left = new int[2]; 
        int[] right = new int[2];

        if (node.left != null) {
            left = rec(node.left);
            left[1]++; //adding the edge to get there
        }

        if (node.right != null){
            right = rec(node.right);
            right[1]++; // adding the edge to get there
        } 
            
        
        int[] res = new int[2];
        res[0] = Math.max(left[0],right[0]);
        res[0] = Math.max(left[1] + right[1], res[0]);
        res[1] = Math.max(left[1], right[1]);
        return res;
    }
}
