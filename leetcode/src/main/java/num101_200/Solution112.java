package num101_200;

import helper.TreeNode;

/**
 * 112. 路径总和
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}