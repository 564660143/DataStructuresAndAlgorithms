package num1_100;

import helper.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 二叉搜索树的中序遍历节点顺序是有序的
 */
class Solution98 {
    // 保存上一次遍历的节点值, 设置为long类型, 是要确保初始时比树中所有节点都小
    long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历先遍历左侧节点, 再遍历当前节点, 然后遍历右侧节点
        // 遍历左子树
        if (isValidBST(root.left)) {
            // 判断是否有序
            if (last < root.val) {
                // 遍历当前节点
                last = root.val;
                // 遍历右子树
                return isValidBST(root.right);
            }
        }
        return false;
    }
}