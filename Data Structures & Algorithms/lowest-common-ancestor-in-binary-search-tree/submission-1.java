class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();

        dfs(root, p, pList);
        dfs(root, q, qList);

        TreeNode LCA = new TreeNode(101);
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i) != qList.get(i))
                break;

            LCA = pList.get(i);

        }

        return LCA;

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
