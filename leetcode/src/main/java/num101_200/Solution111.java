package num101_200;

import helper.TreeNode;

/**
 * 111. 二叉树的最小深度
 */
class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth;
        if (root.left == null) {
            depth = minDepth(root.right);
        } else if (root.right == null) {
            depth = minDepth(root.left);
        } else {
            depth = Math.min(minDepth(root.left), minDepth(root.right));;
        }

        return depth + 1;
    }
}