package num201_300;

import helper.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 */
class Solution230 {
    private int kthSmallest;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return kthSmallest;
    }

    private void inOrder(TreeNode root) {
        if (root == null || k < 1) {
            return;
        }

        inOrder(root.left);
        // k == 1时表示已经找到了第k个最小元素
        if (k == 1) {
            kthSmallest = root.val;
        }
        k--;
        inOrder(root.right);
    }

}