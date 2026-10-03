class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base cases
        if (root == null) return false;
        
        // If the trees match structurally and by value, we found it
        if (isSameTree(root, subRoot)) return true;
        
        // Otherwise, keep searching down the left and right branches
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to strictly check if two trees are exactly identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both are null -> match
        if (p == null && q == null) return true;
        
        // One is null or values don't match -> mismatch
        if (p == null || q == null || p.val != q.val) return false;
        
        // Check children recursively
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}