package num201_300;

import helper.TreeNode;

/**
 * 226. 翻转二叉树
 */
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}