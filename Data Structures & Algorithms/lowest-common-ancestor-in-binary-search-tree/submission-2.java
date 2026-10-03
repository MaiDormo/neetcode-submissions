class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();

        dfs(root, p, pList);
        dfs(root, q, qList);

        int i = 0;
        int minLen = Math.min(pList.size(), qList.size());
        while (i < minLen && pList.get(i) == qList.get(i)) {
            i++;
        }
        return pList.get(i - 1);
    }

    private void dfs(TreeNode node, TreeNode p, List<TreeNode> l) {
        if (node == null)
            return;
        if (node == p) {
            l.add(node);
            return;
        }

        l.add(node);
        if (p.val < node.val) {
            dfs(node.left, p, l);
        } else {
            dfs(node.right, p, l);
        }
    }
}
