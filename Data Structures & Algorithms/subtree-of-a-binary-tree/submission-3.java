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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean[] res = new boolean[]{false};
        String toCheck = collectString(subRoot);
        rec(root,toCheck,res);
        return res[0];
    }

    private String collectString(TreeNode node) {
        if (node == null) return "null";
        
        String left = collectString(node.left);
        String right = collectString(node.right);

        String res = left + node.val + right;
        return res;
    }

    private String rec(TreeNode node, String toCheck, boolean[] res) {
        if (node == null || res[0] == true) return "null";
        
        String left = rec(node.left,toCheck,res);
        if (left.equals(toCheck)) res[0] = true;
        
        String right = rec(node.right,toCheck,res);
        if (right.equals(toCheck)) res[0] = true;

        String val = left + node.val + right;
        if (val.equals(toCheck)) res[0] = true;
        return val;
    }
}
