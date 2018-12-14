package num101_200;

import helper.TreeNode;

/**
 * 110. 平衡二叉树
 */
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 获取节点高度
    private int getHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 完全二叉树的高度由左侧的节点得到
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}