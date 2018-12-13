package num101_200;

import helper.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树深度
        int leftDepth = maxDepth(root.left);
        // 右子树深度
        int rightDepth = maxDepth(root.right);
        // 当前节点最大深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

}