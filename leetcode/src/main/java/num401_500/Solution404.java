package num401_500;

import helper.TreeNode;

/**
 * 404. 左叶子之和
 */
class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root,false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        // 是否为左叶子节点
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        } else {
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
    }
}